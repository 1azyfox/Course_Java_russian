import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

    }

    class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int arraySize = objectInputStream.readInt();
            Animal[] deserializedAnimalArray = new Animal[arraySize];
            for (int i = 0; i < arraySize; i++) {
                Animal animal = (Animal) objectInputStream.readObject();
                deserializedAnimalArray[i] = animal;
            }
            return deserializedAnimalArray;
        } catch (IOException | SecurityException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException();
        }
    }
}
