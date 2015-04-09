package c.mars;

import org.apache.commons.codec.binary.Hex;

public class Main {

    public static void main(String[] args) {
	    String uuid = "F000XXXX-0451-4000-B000-000000000000";
        System.out.println(uuid.substring(4,8));

        byte[] v = {0,1,0,1,0};
//        String s = "0x";
//        for(byte b:v){
//            s+=String.format("%02x", b);
//        }
//        System.out.println(s);

        System.out.println("0x"+String.valueOf(Hex.encodeHex(v)));
    }
}
