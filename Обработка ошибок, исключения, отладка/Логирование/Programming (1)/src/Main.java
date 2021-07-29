import java.util.logging.*;

public class Main {
    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */
    public static interface Sendable {
        String getFrom();

        String getTo();
    }

    /*
    Абстрактный класс,который позволяет абстрагировать логику хранения
    источника и получателя письма в соответствующих полях класса.
    */
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }

    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }

    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }

    /*
Класс, который задает посылку.
У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    /*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static class UntrustworthyMailWorker implements MailService {

        MailService[] mailServices;
        RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable UntrustworthyMailWorkerMail = mail;
            for (int i = 0; i < mailServices.length - 1; i++) {
                UntrustworthyMailWorkerMail = mailServices[i + 1].processMail(mailServices[i].processMail(mail));
            }
            return realMailService.processMail(UntrustworthyMailWorkerMail);
        }
    }

    public static class Spy implements MailService {

        private Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (mail.getFrom().lastIndexOf(AUSTIN_POWERS) != -1 | mail.getTo().lastIndexOf(AUSTIN_POWERS) != -1) {
//                    String msg = "WARN: Detected target mail correspondence: from (%s) to (%s) \"{(%s)}\"";
//                    logger.warning(String.format(msg, mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()));
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
                } else {
//                    String msg = "INFO: Usual correspondence: from (%s) to (%s)";
//                    logger.info(String.format(msg, mail.getFrom(), mail.getTo()));
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[]{mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService {
        private int minPackagePrice;
        private int stolenValue = 0;

        public Thief(int minPackagePrice) {
            this.minPackagePrice = minPackagePrice;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage && ((MailPackage) mail).getContent().getPrice() >= minPackagePrice) {
                stolenValue += ((MailPackage) mail).getContent().getPrice();
//                String newContent = "stones instead of (%s)";
                return new MailPackage(mail.getFrom(), mail.getTo(),
                        new Package("stones instead of " + ((MailPackage) mail).getContent(), 0));
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {
        }
    }

    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getContent().lastIndexOf(WEAPONS) != -1 ||
                        ((MailPackage) mail).getContent().getContent().lastIndexOf(BANNED_SUBSTANCE) != -1) {
                    throw new IllegalPackageException();
                }
                if (((MailPackage) mail).getContent().getContent().lastIndexOf("stones") != -1) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }
}