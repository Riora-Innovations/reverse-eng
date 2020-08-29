package com.futaba.androidmadlink.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteArrayConverter {
    public static final String[] Data_ARRAY = {"C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF"};

    public static List<Integer> SettingValues(byte[] datas) {
        if (datas.length < 24) {
            return null;
        }
        char[] collectChars = new char[((datas.length - 2) * 8)];
        int targetIdx = 0;
        for (int i = (datas.length - 2) - 1; i >= 0; i--) {
            char[] binaryArray = ByteToBinaryArray(datas[i]);
            System.arraycopy(binaryArray, 0, collectChars, targetIdx, binaryArray.length);
            targetIdx += binaryArray.length;
        }
        List<Integer> intList = convertToIntArray(collectChars, 11, 16);
        char[] binaryArray2 = ByteToBinaryArray(datas[22]);
        intList.add(Integer.valueOf(Character.getNumericValue(binaryArray2[6])));
        intList.add(Integer.valueOf(Character.getNumericValue(binaryArray2[7])));
        return intList;
    }

    public static Object[] DataToByteArray(byte[] datas, Object[] data2Value) {
        for (int i = 0; i < datas.length; i += 3) {
            int IndexD = Arrays.binarySearch(Data_ARRAY, Integer.toHexString(Integer.parseInt(String.valueOf(revertArray(ByteToBinaryArray(datas[i]))), 2)).trim().toUpperCase());
            if (IndexD >= 0) {
                data2Value[IndexD] = new byte[]{datas[i + 1], datas[i + 2]};
            }
        }
        return data2Value;
    }

    public static int convertToInt(char[] charArray, int startIdx, int needSize) {
        char[] thisChars = new char[needSize];
        System.arraycopy(charArray, startIdx, thisChars, 0, needSize);
        return Integer.parseInt(String.valueOf(thisChars), 2);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[(len / 2)];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static char[] ByteToBinaryArray(byte byteData) {
        return String.format("%8s", new Object[]{Integer.toBinaryString(byteData & 255)}).replace(' ', '0').toCharArray();
    }

    public static String BinaryToHexString(byte[] bytes) {
        String hexStr = "0123456789ABCDEF";
        String result = "";
        String str = "";
        for (int i = 0; i < bytes.length; i++) {
            result = new StringBuilder(String.valueOf(result)).append(new StringBuilder(String.valueOf(String.valueOf(hexStr.charAt((bytes[i] & 240) >> 4)))).append(String.valueOf(hexStr.charAt(bytes[i] & 15))).toString()).toString();
        }
        return result;
    }

    private static char[] revertArray(char[] srcArray) {
        char[] destArray = new char[srcArray.length];
        for (int i = 0; i < srcArray.length; i++) {
            destArray[i] = srcArray[(srcArray.length - i) - 1];
        }
        return destArray;
    }

    private static List<Integer> convertToIntArray(char[] charArray, int parseLength, int needSize) {
        int startIdx = charArray.length;
        List<Integer> intList = new ArrayList<>();
        while (intList.size() < needSize) {
            char[] thisChars = new char[parseLength];
            System.arraycopy(charArray, startIdx - parseLength, thisChars, 0, parseLength);
            intList.add(Integer.valueOf(Integer.parseInt(String.valueOf(thisChars), 2)));
            startIdx -= parseLength;
        }
        return intList;
    }

    public static char[] SlotsToBinaryArray(Object[] bytesData, int startSlotIdx, int useSlotSize) {
        char[] collectChars = new char[(useSlotSize * 2 * 8)];
        int slot = startSlotIdx;
        int targetIdx = 0;
        for (int i = 0; i < useSlotSize; i++) {
            byte[] datas = bytesData[slot];
            if (datas == null) {
                datas = new byte[2];
            }
            for (byte data : datas) {
                char[] binaryArray = ByteToBinaryArray(data);
                System.arraycopy(binaryArray, 0, collectChars, targetIdx, binaryArray.length);
                targetIdx += binaryArray.length;
            }
        }
        return collectChars;
    }

    public static char[] SlotsToBinaryArray2(Object[] bytesData, int startSlotIdx, int useSlotSize) {
        char[] collectChars = new char[(useSlotSize * 2 * 8)];
        int slot = startSlotIdx;
        int targetIdx = 0;
        for (int i = useSlotSize; i > 0; i--) {
            byte[] datas = bytesData[(slot + i) - 1];
            if (datas == null) {
                datas = new byte[2];
            }
            for (int j = datas.length; j > 0; j--) {
                char[] binaryArray = ByteToBinaryArray(datas[j - 1]);
                System.arraycopy(binaryArray, 0, collectChars, targetIdx, binaryArray.length);
                targetIdx += binaryArray.length;
            }
        }
        return collectChars;
    }

    public static boolean SlotsIsNull(Object[] bytesData, int slot) {
        if (bytesData[slot] == null) {
            return true;
        }
        return false;
    }
}
