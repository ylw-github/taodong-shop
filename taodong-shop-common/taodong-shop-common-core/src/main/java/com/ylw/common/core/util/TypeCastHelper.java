package com.ylw.common.core.util;


/**
 * description: 强转工具类
 * create by: YangLinWei
 * create time: 2020/3/3 4:52 下午
 */
public class TypeCastHelper {
	private static final String DEFAULT_STRING = "";
	private static final int DEFAULT_INT = 0;
	private static final long DEFAULT_LONG = 0L;
	private static final double DEFAULT_DOUBLE = 0.0D;
	private static final float DEFAULT_FLOAT = 0.0F;
	private static final boolean DEFAULT_BOOLEAN = Boolean.FALSE;

	public static String toString(Object obj, String defaultValue) {
		return obj != null ? obj.toString() : defaultValue;
	}

	public static String toString(Object obj) {
		return toString(obj, DEFAULT_STRING);
	}

	public static String toString(Integer intValue, String defaultValue) {
		return intValue != null ? String.valueOf(intValue) : defaultValue;
	}

	public static String toString(Integer intValue) {
		return toString(intValue, DEFAULT_STRING);
	}

	public static String toString(Long longValue, String defaultValue) {
		return longValue != null ? String.valueOf(longValue) : defaultValue;
	}

	public static String toString(Long longValue) {
		return toString(longValue, DEFAULT_STRING);
	}

	public static String toString(Boolean booleanValue, String defaultValue) {
		return booleanValue != null ? String.valueOf(booleanValue) : defaultValue;
	}

	public static String toString(Boolean booleanValue) {
		return toString(booleanValue, DEFAULT_STRING);
	}

	public static String toString(Double doubleValue, String defaultValue) {
		return null != doubleValue ? String.valueOf(doubleValue) : defaultValue;
	}

	public static String toString(Double doubleValue) {
		return toString(doubleValue, DEFAULT_STRING);
	}

	public static String toString(Float floatValue, String defaultValue) {
		return null != floatValue ? String.valueOf(floatValue) : defaultValue;
	}

	public static String toString(Float floatValue) {
		return toString(floatValue, DEFAULT_STRING);
	}

	public static int toInt(Object objectValue, int defaultValue) {
		int intValue = defaultValue;
		if (null != objectValue) {
			try {
				intValue = Integer.parseInt(toString(objectValue, toString(defaultValue)));
			} catch (NumberFormatException numberFormatException) {
				System.err.println(numberFormatException.getMessage());
			}
		}
		return intValue;
	}

	public static int toInt(Object objectValue) {
		return toInt(objectValue, DEFAULT_INT);
	}

	public static int toInt(String stringValue, int defaultValue) {
		int intValue = defaultValue;
		if (null != stringValue && stringValue.length() > 0) {
			try {
				intValue = Integer.parseInt(stringValue);
			} catch (NumberFormatException numberFormatException) {
				System.err.println(numberFormatException.getMessage());
			}
		}
		return intValue;
	}

	public static int toInt(Long longValue, int defaultValue) {
		int intValue = defaultValue;
		if (null != longValue) {
			intValue = longValue.intValue();
		}
		return intValue;
	}

	public static int toInt(Long longValue) {
		return toInt(longValue, DEFAULT_INT);
	}

	public static int toInt(Boolean booleanValue, int defaultValue) {
		int intValue = defaultValue;
		if (null != booleanValue) {
			intValue = booleanValue ? 1 : 0;
		}
		return intValue;
	}

	public static int toInt(Boolean booleanValue) {
		return toInt(booleanValue, DEFAULT_INT);
	}

	public static int toInt(Double doubleValue, int defaultValue) {
		int intValue = defaultValue;
		if (null != doubleValue) {
			intValue = doubleValue.intValue();
		}
		return intValue;
	}

	public static int toInt(Double doubleValue) {
		return toInt(doubleValue, DEFAULT_INT);
	}

	public static int toInt(Float floatValue, int defaultValue) {
		int intValue = defaultValue;
		if (null != floatValue) {
			intValue = floatValue.intValue();
		}
		return intValue;
	}

	public static int toInt(Float floatValue) {
		return toInt(floatValue, DEFAULT_INT);
	}

	public static long toLong(Object objectValue, long defaultValue) {
		long longValue = defaultValue;
		if (null != objectValue) {
			try {
				longValue = Long.parseLong(toString(objectValue, toString(defaultValue)));
			} catch (NumberFormatException numberFormatException) {
				System.err.println(numberFormatException.getMessage());
			}
		}
		return longValue;
	}

	public static long toLong(Object objectValue) {
		return toLong(objectValue, DEFAULT_LONG);
	}

	public static long toLong(String stringValue, long defaultValue) {
		long longValue = defaultValue;
		if (null != stringValue && stringValue.length() > 0) {
			longValue = Long.parseLong(stringValue);
		}
		return longValue;
	}

	public static long toLong(String stringValue) {
		return toLong(stringValue, DEFAULT_LONG);
	}

	public static long toLong(Integer intValue, long defaultValue) {
		long longValue = defaultValue;
		if (null != intValue) {
			longValue = intValue.longValue();
		}
		return longValue;
	}

	public static long toLong(Integer intValue) {
		return toLong(intValue, DEFAULT_LONG);
	}

	public static long toLong(Boolean booleanValue, long defaultValue) {
		long longValue = defaultValue;
		if (null != booleanValue) {
			longValue = booleanValue ? 1L : 0L;
		}
		return longValue;
	}

	public static long toLong(Boolean booleanValue) {
		return toLong(booleanValue, DEFAULT_LONG);
	}

	public static long toLong(Double doubleValue, long defaultValue) {
		long longValue = defaultValue;
		if (null != doubleValue) {
			longValue = doubleValue.longValue();
		}
		return longValue;
	}

	public static long toLong(Double doubleValue) {
		return toLong(doubleValue, DEFAULT_LONG);
	}

	public static long toLong(Float floatValue, long defaultValue) {
		long longValue = defaultValue;
		if (null != floatValue) {
			longValue = floatValue.longValue();
		}
		return longValue;
	}

	public static long toLong(Float floatValue) {
		return toLong(floatValue, DEFAULT_LONG);
	}

	public static boolean toBoolean(Object objectValue, boolean defaultValue) {
		boolean booleanValue = defaultValue;
		if (null != objectValue) {
			booleanValue = Boolean.valueOf(toString(objectValue, toString(defaultValue)));
		}
		return booleanValue;
	}

	public static boolean toBoolean(Object objectValue) {
		return toBoolean(objectValue, DEFAULT_BOOLEAN);
	}

	public static boolean toBoolean(String stringValue, boolean defaultValue) {
		boolean booleanValue = defaultValue;
		if (null != stringValue && stringValue.length() > 0) {
			booleanValue = Boolean.valueOf(stringValue);
		}
		return booleanValue;
	}

	public static boolean toBoolean(String stringValue) {
		return toBoolean(stringValue, DEFAULT_BOOLEAN);
	}

	public static boolean toBoolean(Integer intValue, boolean defaultValue) {
		boolean booleanValue = defaultValue;
		if (null != intValue) {
			booleanValue = intValue == 1;
		}
		return booleanValue;
	}

	public static boolean toBoolean(Integer intValue) {
		return toBoolean(intValue, DEFAULT_BOOLEAN);
	}

	public static boolean toBoolean(Long longValue, boolean defaultValue) {
		boolean booleanValue = defaultValue;
		if (null != longValue) {
			booleanValue = longValue.longValue() == 1L;
		}
		return booleanValue;
	}

	public static boolean toBoolean(Long longValue) {
		return toBoolean(longValue, DEFAULT_BOOLEAN);
	}

	public static float toFloat(Object objectValue, float defaultValue) {
		float floatValue = defaultValue;
		if (null != objectValue) {
			try {
				floatValue = Float.valueOf(toString(objectValue, toString(defaultValue)));
			} catch (NumberFormatException numberFormatException) {
				System.err.println(numberFormatException);
			}
		}
		return floatValue;
	}

	public static float toFloat(Object objectValue) {
		return toFloat(objectValue, DEFAULT_FLOAT);
	}

	public static float toFloat(String stringValue, float defaultValue) {
		float floatValue = defaultValue;
		if (null != stringValue && stringValue.length() > 0) {
			try {
				floatValue = Float.valueOf(stringValue);
			} catch (NumberFormatException numberFormatException) {
				System.err.println(numberFormatException.getMessage());
			}
		}
		return floatValue;
	}

	public static float toFloat(String stringValue) {
		return toFloat(stringValue, DEFAULT_FLOAT);
	}

	public static float toFloat(Integer intValue, float defaultValue) {
		float floatValue = defaultValue;
		if (null != intValue) {
			floatValue = intValue.floatValue();
		}
		return floatValue;
	}

	public static float toFloat(Integer intValue) {
		return toFloat(intValue, DEFAULT_FLOAT);
	}

	public static float toFloat(Long longValue, float defaultValue) {
		float floatValue = defaultValue;
		if (null != longValue) {
			floatValue = longValue.floatValue();
		}
		return floatValue;
	}

	public static float toFloat(Long longValue) {
		return toFloat(longValue, DEFAULT_FLOAT);
	}

	public static float toFloat(Double doubleValue, float defaultValue) {
		float floatValue = defaultValue;
		if (null != doubleValue) {
			floatValue = doubleValue.floatValue();
		}
		return floatValue;
	}

	public static float toFloat(Double doubleValue) {
		return toFloat(doubleValue, DEFAULT_FLOAT);
	}

	public static double toDouble(Object objectValue, double defaultValue) {
		double doubleValue = defaultValue;
		if (null != objectValue) {
			doubleValue = Double.parseDouble(toString(objectValue, toString(defaultValue)));
		}
		return doubleValue;
	}

	public static double toDouble(Object objectValue) {
		return toDouble(objectValue, DEFAULT_DOUBLE);
	}

	public static double toDouble(String stringValue, double defaultValue) {
		double doubleValue = defaultValue;
		if (null != stringValue && stringValue.length() > 0) {
			doubleValue = Double.parseDouble(stringValue);
		}
		return doubleValue;
	}

	public static double toDouble(String stringValue) {
		return toDouble(stringValue, DEFAULT_DOUBLE);
	}

	public static double toDouble(Integer intValue, double defaultValue) {
		double doubleValue = defaultValue;
		if (null != intValue) {
			doubleValue = intValue.doubleValue();
		}
		return doubleValue;
	}

	public static double toDouble(Integer intValue) {
		return toDouble(intValue, DEFAULT_DOUBLE);
	}

	public static double toDouble(Long longValue, double defaultValue) {
		double doubleValue = defaultValue;
		if (null != longValue) {
			doubleValue = longValue.doubleValue();
		}
		return doubleValue;
	}

	public static double toDouble(Long longValue) {
		return toDouble(longValue, DEFAULT_DOUBLE);
	}

	public static double toDouble(Float floatValue, double defaultValue) {
		double doubleValue = defaultValue;
		if (null != floatValue) {
			doubleValue = floatValue.doubleValue();
		}
		return doubleValue;
	}

	public static double toDouble(Float floatValue) {
		return toDouble(floatValue, DEFAULT_DOUBLE);
	}

}
