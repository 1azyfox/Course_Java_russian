/**
 * Calculates factorial of given <code>value</code>.
 *
 * @param value positive number
 * @return factorial of <code>value</code>
 */
public static BigInteger factorial(int value){
        BigInteger answer=BigInteger.ONE;
        BigInteger valueToBigInteger=new BigInteger(String.valueOf(value));
        for(BigInteger i=BigInteger.ONE;i.compareTo(valueToBigInteger)!=1;i=i.add(BigInteger.ONE)){
        answer=answer.multiply(i);
        }
        return answer;
        }