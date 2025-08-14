import java.math.BigInteger;

class Solution {
  public int solution(int balls, int share) {
    BigInteger sameBalls = new BigInteger("" + (balls + 1));
    BigInteger sameShare = new BigInteger("" + (share + 1));
    BigInteger ballMul = new BigInteger("1");
    BigInteger shareMul = new BigInteger("1");
    BigInteger one = new BigInteger("1");
    for(int i = 0 ; i < share ; i++){
      sameBalls = sameBalls.subtract(one);
      sameShare = sameShare.subtract(one);
      ballMul =ballMul.multiply(sameBalls);
      shareMul =shareMul.multiply(sameShare);

    }
    return (ballMul.divide(shareMul)).intValue();
  }
}