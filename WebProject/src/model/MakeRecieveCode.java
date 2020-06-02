package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MakeRecieveCode {
	public static String makeCode(List<OrderDetailBean> odl) {

		String value = odl.toString() + new Date().toString();


        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] result = digest.digest(value.getBytes());
            String l = Long.toString( new BigInteger(1, result).longValue(), 32);

            return l;
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
	}

	public static void main(String[] args) {
		makeCode(new ArrayList<>());
	}
}
