package android.support.media;

import android.content.res.AssetManager.AssetInputStream;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.InputDeviceCompat;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = (short) 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = (short) 1;
    private static final Charset ASCII = Charset.forName("US-ASCII");
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = new int[]{4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = new int[]{8};
    public static final int[] BITS_PER_SAMPLE_RGB = new int[]{8, 8, 8};
    static final short BYTE_ALIGN_II = (short) 18761;
    static final short BYTE_ALIGN_MM = (short) 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = (short) 2;
    public static final short CONTRAST_NORMAL = (short) 0;
    public static final short CONTRAST_SOFT = (short) 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final boolean DEBUG = false;
    private static final byte[] EXIF_ASCII_PREFIX = new byte[]{(byte) 65, (byte) 83, (byte) 67, (byte) 73, (byte) 73, (byte) 0, (byte) 0, (byte) 0};
    private static final ExifTag[] EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
    static final ExifTag[][] EXIF_TAGS = new ExifTag[][]{IFD_TIFF_TAGS, IFD_EXIF_TAGS, IFD_GPS_TAGS, IFD_INTEROPERABILITY_TAGS, IFD_THUMBNAIL_TAGS, IFD_TIFF_TAGS, ORF_MAKER_NOTE_TAGS, ORF_CAMERA_SETTINGS_TAGS, ORF_IMAGE_PROCESSING_TAGS, PEF_TAGS};
    public static final short EXPOSURE_MODE_AUTO = (short) 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = (short) 2;
    public static final short EXPOSURE_MODE_MANUAL = (short) 1;
    public static final short EXPOSURE_PROGRAM_ACTION = (short) 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = (short) 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = (short) 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = (short) 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = (short) 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = (short) 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = (short) 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = (short) 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = (short) 4;
    public static final short FILE_SOURCE_DSC = (short) 3;
    public static final short FILE_SOURCE_OTHER = (short) 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = (short) 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = (short) 1;
    public static final short FLAG_FLASH_FIRED = (short) 1;
    public static final short FLAG_FLASH_MODE_AUTO = (short) 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = (short) 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = (short) 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = (short) 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = (short) 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = (short) 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = (short) 4;
    private static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(5)});
    public static final short FORMAT_CHUNKY = (short) 1;
    public static final short FORMAT_PLANAR = (short) 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = (short) 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = (short) 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = (short) 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = (short) 1;
    public static final short GAIN_CONTROL_NONE = (short) 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = (short) 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = (short) 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    static final byte[] IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(ASCII);
    private static final ExifTag[] IFD_EXIF_TAGS = new ExifTag[]{new ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(TAG_F_NUMBER, 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(TAG_OECF, 34856, 7), new ExifTag(TAG_EXIF_VERSION, 36864, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifTag(TAG_METERING_MODE, 37383, 3), new ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(TAG_FLASH, 37385, 3), new ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(TAG_FLASHPIX_VERSION, 40960, 7), new ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
    private static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    static final String[] IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifTag[] IFD_GPS_TAGS = new ExifTag[]{new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(TAG_GPS_LATITUDE, 2, 5), new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(TAG_GPS_LONGITUDE, 4, 5), new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3)};
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS = new ExifTag[]{new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
    private static final int IFD_OFFSET = 8;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS = new ExifTag[]{new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, InputDeviceCompat.SOURCE_KEYBOARD, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, (int) InputDeviceCompat.SOURCE_DPAD, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
    private static final ExifTag[] IFD_TIFF_TAGS = new ExifTag[]{new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_IMAGE_LENGTH, InputDeviceCompat.SOURCE_KEYBOARD, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, (int) InputDeviceCompat.SOURCE_DPAD, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7)};
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    private static final int IMAGE_TYPE_ARW = 1;
    private static final int IMAGE_TYPE_CR2 = 2;
    private static final int IMAGE_TYPE_DNG = 3;
    private static final int IMAGE_TYPE_JPEG = 4;
    private static final int IMAGE_TYPE_NEF = 5;
    private static final int IMAGE_TYPE_NRW = 6;
    private static final int IMAGE_TYPE_ORF = 7;
    private static final int IMAGE_TYPE_PEF = 8;
    private static final int IMAGE_TYPE_RAF = 9;
    private static final int IMAGE_TYPE_RW2 = 10;
    private static final int IMAGE_TYPE_SRW = 11;
    private static final int IMAGE_TYPE_UNKNOWN = 0;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, (int) InputDeviceCompat.SOURCE_DPAD, 4);
    static final byte[] JPEG_SIGNATURE = new byte[]{MARKER, MARKER_SOI, MARKER};
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = (short) 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = (short) 14;
    public static final short LIGHT_SOURCE_D50 = (short) 23;
    public static final short LIGHT_SOURCE_D55 = (short) 20;
    public static final short LIGHT_SOURCE_D65 = (short) 21;
    public static final short LIGHT_SOURCE_D75 = (short) 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = (short) 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = (short) 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = (short) 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = (short) 9;
    public static final short LIGHT_SOURCE_FLASH = (short) 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = (short) 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = (short) 24;
    public static final short LIGHT_SOURCE_OTHER = (short) 255;
    public static final short LIGHT_SOURCE_SHADE = (short) 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = (short) 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = (short) 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = (short) 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = (short) 3;
    public static final short LIGHT_SOURCE_UNKNOWN = (short) 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = (short) 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = (short) 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    static final byte MARKER = (byte) -1;
    static final byte MARKER_APP1 = (byte) -31;
    private static final byte MARKER_COM = (byte) -2;
    static final byte MARKER_EOI = (byte) -39;
    private static final byte MARKER_SOF0 = (byte) -64;
    private static final byte MARKER_SOF1 = (byte) -63;
    private static final byte MARKER_SOF10 = (byte) -54;
    private static final byte MARKER_SOF11 = (byte) -53;
    private static final byte MARKER_SOF13 = (byte) -51;
    private static final byte MARKER_SOF14 = (byte) -50;
    private static final byte MARKER_SOF15 = (byte) -49;
    private static final byte MARKER_SOF2 = (byte) -62;
    private static final byte MARKER_SOF3 = (byte) -61;
    private static final byte MARKER_SOF5 = (byte) -59;
    private static final byte MARKER_SOF6 = (byte) -58;
    private static final byte MARKER_SOF7 = (byte) -57;
    private static final byte MARKER_SOF9 = (byte) -55;
    private static final byte MARKER_SOI = (byte) -40;
    private static final byte MARKER_SOS = (byte) -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = (short) 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = (short) 2;
    public static final short METERING_MODE_MULTI_SPOT = (short) 4;
    public static final short METERING_MODE_OTHER = (short) 255;
    public static final short METERING_MODE_PARTIAL = (short) 6;
    public static final short METERING_MODE_PATTERN = (short) 5;
    public static final short METERING_MODE_SPOT = (short) 3;
    public static final short METERING_MODE_UNKNOWN = (short) 0;
    private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS = new ExifTag[]{new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, (int) InputDeviceCompat.SOURCE_KEYBOARD, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
    private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS = new ExifTag[]{new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 0};
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 85, (byte) 83, (byte) 0, (byte) 73, (byte) 73};
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifTag[] ORF_MAKER_NOTE_TAGS = new ExifTag[]{new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
    private static final short ORF_SIGNATURE_1 = (short) 20306;
    private static final short ORF_SIGNATURE_2 = (short) 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifTag[] PEF_TAGS = new ExifTag[]{new ExifTag(TAG_COLOR_SPACE, 55, 3)};
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int RAF_INFO_SIZE = 160;
    private static final int RAF_JPEG_LENGTH_VALUE_SIZE = 4;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = (short) 1;
    public static final short RENDERED_PROCESS_NORMAL = (short) 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = (short) 3;
    public static final short RESOLUTION_UNIT_INCHES = (short) 2;
    private static final List<Integer> ROTATION_ORDER = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(3), Integer.valueOf(8)});
    private static final short RW2_SIGNATURE = (short) 85;
    public static final short SATURATION_HIGH = (short) 0;
    public static final short SATURATION_LOW = (short) 0;
    public static final short SATURATION_NORMAL = (short) 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = (short) 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = (short) 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = (short) 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = (short) 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = (short) 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = (short) 3;
    public static final short SENSITIVITY_TYPE_REI = (short) 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = (short) 6;
    public static final short SENSITIVITY_TYPE_SOS = (short) 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = (short) 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = (short) 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = (short) 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = (short) 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = (short) 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = (short) 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = (short) 1;
    public static final short SENSOR_TYPE_ONE_CHIP = (short) 2;
    public static final short SENSOR_TYPE_THREE_CHIP = (short) 4;
    public static final short SENSOR_TYPE_TRILINEAR = (short) 7;
    public static final short SENSOR_TYPE_TWO_CHIP = (short) 3;
    public static final short SHARPNESS_HARD = (short) 2;
    public static final short SHARPNESS_NORMAL = (short) 0;
    public static final short SHARPNESS_SOFT = (short) 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    static final byte START_CODE = (byte) 42;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = (short) 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = (short) 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = (short) 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = (short) 0;
    private static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    private static final String TAG_HAS_THUMBNAIL = "HasThumbnail";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifTag TAG_RAF_IMAGE_SIZE = new ExifTag(TAG_STRIP_OFFSETS, 273, 3);
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    private static final String TAG_THUMBNAIL_DATA = "ThumbnailData";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    private static final String TAG_THUMBNAIL_LENGTH = "ThumbnailLength";
    private static final String TAG_THUMBNAIL_OFFSET = "ThumbnailOffset";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = (short) 0;
    public static final short WHITE_BALANCE_MANUAL = (short) 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = (short) 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = (short) 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap = new HashMap();
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading = new HashMap[EXIF_TAGS.length];
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting = new HashMap[EXIF_TAGS.length];
    private static SimpleDateFormat sFormatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    private static final Pattern sGpsTimestampPattern = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    private static final Pattern sNonZeroTimePattern = Pattern.compile(".*[1-9].*");
    private static final HashSet<String> sTagSetForCompatibility = new HashSet(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
    private final AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private ByteOrder mExifByteOrder;
    private int mExifOffset;
    private final String mFilename;
    private boolean mHasThumbnail;
    private boolean mIsSupportedFile;
    private int mMimeType;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private int mRw2JpgFromRawOffset;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;

    private static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        private ByteOrder mByteOrder;
        private DataInputStream mDataInputStream;
        private final int mLength;
        private int mPosition;

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            this.mDataInputStream = new DataInputStream(inputStream);
            this.mLength = this.mDataInputStream.available();
            this.mPosition = null;
            this.mDataInputStream.mark(this.mLength);
        }

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public void seek(long j) throws IOException {
            if (((long) this.mPosition) > j) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
                this.mDataInputStream.mark(this.mLength);
            } else {
                j -= (long) this.mPosition;
            }
            j = (int) j;
            if (skipBytes(j) != j) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public int peek() {
            return this.mPosition;
        }

        public int available() throws IOException {
            return this.mDataInputStream.available();
        }

        public int read() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            bArr = this.mDataInputStream.read(bArr, i, i2);
            this.mPosition += bArr;
            return bArr;
        }

        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        public String readLine() throws IOException {
            Log.d(ExifInterface.TAG, "Currently unsupported");
            return null;
        }

        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.mPosition += i2;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            } else if (this.mDataInputStream.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public void readFully(byte[] bArr) throws IOException {
            this.mPosition += bArr.length;
            if (this.mPosition > this.mLength) {
                throw new EOFException();
            } else if (this.mDataInputStream.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public byte readByte() throws IOException {
            this.mPosition++;
            if (this.mPosition <= this.mLength) {
                int read = this.mDataInputStream.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            this.mPosition += 2;
            if (this.mPosition <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) < 0) {
                    throw new EOFException();
                } else if (this.mByteOrder == LITTLE_ENDIAN) {
                    return (short) ((read2 << 8) + read);
                } else {
                    if (this.mByteOrder == BIG_ENDIAN) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid byte order: ");
                    stringBuilder.append(this.mByteOrder);
                    throw new IOException(stringBuilder.toString());
                }
            }
            throw new EOFException();
        }

        public int readInt() throws IOException {
            this.mPosition += 4;
            if (this.mPosition <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                if ((((read | read2) | read3) | read4) < 0) {
                    throw new EOFException();
                } else if (this.mByteOrder == LITTLE_ENDIAN) {
                    return (((read4 << 24) + (read3 << 16)) + (read2 << 8)) + read;
                } else {
                    if (this.mByteOrder == BIG_ENDIAN) {
                        return (((read << 24) + (read2 << 16)) + (read3 << 8)) + read4;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid byte order: ");
                    stringBuilder.append(this.mByteOrder);
                    throw new IOException(stringBuilder.toString());
                }
            }
            throw new EOFException();
        }

        public int skipBytes(int i) throws IOException {
            i = Math.min(i, this.mLength - this.mPosition);
            int i2 = 0;
            while (i2 < i) {
                i2 += this.mDataInputStream.skipBytes(i - i2);
            }
            this.mPosition += i2;
            return i2;
        }

        public int readUnsignedShort() throws IOException {
            this.mPosition += 2;
            if (this.mPosition <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) < 0) {
                    throw new EOFException();
                } else if (this.mByteOrder == LITTLE_ENDIAN) {
                    return (read2 << 8) + read;
                } else {
                    if (this.mByteOrder == BIG_ENDIAN) {
                        return (read << 8) + read2;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid byte order: ");
                    stringBuilder.append(this.mByteOrder);
                    throw new IOException(stringBuilder.toString());
                }
            }
            throw new EOFException();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public long readLong() throws IOException {
            this.mPosition += 8;
            if (this.mPosition <= this.mLength) {
                int read = r0.mDataInputStream.read();
                int read2 = r0.mDataInputStream.read();
                int read3 = r0.mDataInputStream.read();
                int read4 = r0.mDataInputStream.read();
                int read5 = r0.mDataInputStream.read();
                int read6 = r0.mDataInputStream.read();
                int read7 = r0.mDataInputStream.read();
                int read8 = r0.mDataInputStream.read();
                if ((((((((read | read2) | read3) | read4) | read5) | read6) | read7) | read8) < 0) {
                    throw new EOFException();
                } else if (r0.mByteOrder == LITTLE_ENDIAN) {
                    return (((((((((long) read8) << 56) + (((long) read7) << 48)) + (((long) read6) << 40)) + (((long) read5) << 32)) + (((long) read4) << 24)) + (((long) read3) << 16)) + (((long) read2) << 8)) + ((long) read);
                } else {
                    int i = read2;
                    if (r0.mByteOrder == BIG_ENDIAN) {
                        return (((((((((long) read) << 56) + (((long) i) << 48)) + (((long) read3) << 40)) + (((long) read4) << 32)) + (((long) read5) << 24)) + (((long) read6) << 16)) + (((long) read7) << 8)) + ((long) read8);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid byte order: ");
                    stringBuilder.append(r0.mByteOrder);
                    throw new IOException(stringBuilder.toString());
                }
            }
            throw new EOFException();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }
    }

    private static class ByteOrderedDataOutputStream extends FilterOutputStream {
        private ByteOrder mByteOrder;
        private final OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.mOutputStream = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public void write(byte[] bArr) throws IOException {
            this.mOutputStream.write(bArr);
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.mOutputStream.write(bArr, i, i2);
        }

        public void writeByte(int i) throws IOException {
            this.mOutputStream.write(i);
        }

        public void writeShort(short s) throws IOException {
            if (this.mByteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((s >>> 0) & 255);
                this.mOutputStream.write((s >>> 8) & 255);
            } else if (this.mByteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((s >>> 8) & 255);
                this.mOutputStream.write((s >>> 0) & 255);
            }
        }

        public void writeInt(int i) throws IOException {
            if (this.mByteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((i >>> 0) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 24) & 255);
            } else if (this.mByteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((i >>> 24) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write((i >>> 0) & 255);
            }
        }

        public void writeUnsignedShort(int i) throws IOException {
            writeShort((short) i);
        }

        public void writeUnsignedInt(long j) throws IOException {
            writeInt((int) j);
        }
    }

    private static class ExifAttribute {
        public final byte[] bytes;
        public final int format;
        public final int numberOfComponents;

        private ExifAttribute(int i, int i2, byte[] bArr) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytes = bArr;
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int i, ByteOrder byteOrder) {
            return createUShort(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
            return createULong(new long[]{j}, byteOrder);
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute createSLong(int i, ByteOrder byteOrder) {
            return createSLong(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                str = str.getBytes(ExifInterface.ASCII);
                return new ExifAttribute(1, str.length, str);
            }
            byte[] bArr = new byte[]{(byte) (str.charAt(0) - 48)};
            return new ExifAttribute(1, bArr.length, bArr);
        }

        public static ExifAttribute createString(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(null);
            str = stringBuilder.toString().getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, str.length, str);
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            return createSRational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute createDouble(double d, ByteOrder byteOrder) {
            return createDouble(new double[]{d}, byteOrder);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(");
            stringBuilder.append(ExifInterface.IFD_FORMAT_NAMES[this.format]);
            stringBuilder.append(", data length:");
            stringBuilder.append(this.bytes.length);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        private Object getValue(ByteOrder byteOrder) {
            ByteOrderedDataInputStream byteOrderedDataInputStream;
            try {
                byteOrderedDataInputStream = new ByteOrderedDataInputStream(this.bytes);
                try {
                    byteOrderedDataInputStream.setByteOrder(byteOrder);
                    int i = 1;
                    int i2 = 0;
                    switch (this.format) {
                        case 1:
                        case 6:
                            if (this.bytes.length != 1 || this.bytes[0] < null || this.bytes[0] > 1) {
                                byteOrder = new String(this.bytes, ExifInterface.ASCII);
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (Throwable e) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e);
                                }
                                return byteOrder;
                            }
                            byteOrder = new String(new char[]{(char) (this.bytes[0] + 48)});
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (Throwable e2) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e2);
                            }
                            return byteOrder;
                        case 2:
                        case 7:
                            if (this.numberOfComponents >= ExifInterface.EXIF_ASCII_PREFIX.length) {
                                byteOrder = null;
                                while (byteOrder < ExifInterface.EXIF_ASCII_PREFIX.length) {
                                    if (this.bytes[byteOrder] != ExifInterface.EXIF_ASCII_PREFIX[byteOrder]) {
                                        i = 0;
                                        if (i != 0) {
                                            i2 = ExifInterface.EXIF_ASCII_PREFIX.length;
                                        }
                                    } else {
                                        byteOrder++;
                                    }
                                }
                                if (i != 0) {
                                    i2 = ExifInterface.EXIF_ASCII_PREFIX.length;
                                }
                            }
                            byteOrder = new StringBuilder();
                            for (i2 = 
/*
Method generation error in method: android.support.media.ExifInterface.ExifAttribute.getValue(java.nio.ByteOrder):java.lang.Object
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r3_18 'i2' int) = (r3_0 'i2' int), (r3_0 'i2' int), (r3_17 'i2' int) binds: {(r3_0 'i2' int)=B:112:0x013f, (r3_17 'i2' int)=B:113:0x0141, (r3_0 'i2' int)=B:104:0x0124} in method: android.support.media.ExifInterface.ExifAttribute.getValue(java.nio.ByteOrder):java.lang.Object
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:264)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:277)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:277)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:241)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 33 more

*/

                            public double getDoubleValue(ByteOrder byteOrder) {
                                byteOrder = getValue(byteOrder);
                                if (byteOrder == null) {
                                    throw new NumberFormatException("NULL can't be converted to a double value");
                                } else if (byteOrder instanceof String) {
                                    return Double.parseDouble((String) byteOrder);
                                } else {
                                    if (byteOrder instanceof long[]) {
                                        long[] jArr = (long[]) byteOrder;
                                        if (jArr.length == 1) {
                                            return (double) jArr[0];
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else if (byteOrder instanceof int[]) {
                                        int[] iArr = (int[]) byteOrder;
                                        if (iArr.length == 1) {
                                            return (double) iArr[0];
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else if (byteOrder instanceof double[]) {
                                        double[] dArr = (double[]) byteOrder;
                                        if (dArr.length == 1) {
                                            return dArr[0];
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else if (byteOrder instanceof Rational[]) {
                                        Rational[] rationalArr = (Rational[]) byteOrder;
                                        if (rationalArr.length == 1) {
                                            return rationalArr[0].calculate();
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else {
                                        throw new NumberFormatException("Couldn't find a double value");
                                    }
                                }
                            }

                            public int getIntValue(ByteOrder byteOrder) {
                                byteOrder = getValue(byteOrder);
                                if (byteOrder == null) {
                                    throw new NumberFormatException("NULL can't be converted to a integer value");
                                } else if (byteOrder instanceof String) {
                                    return Integer.parseInt((String) byteOrder);
                                } else {
                                    if (byteOrder instanceof long[]) {
                                        long[] jArr = (long[]) byteOrder;
                                        if (jArr.length == 1) {
                                            return (int) jArr[0];
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else if (byteOrder instanceof int[]) {
                                        int[] iArr = (int[]) byteOrder;
                                        if (iArr.length == 1) {
                                            return iArr[0];
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else {
                                        throw new NumberFormatException("Couldn't find a integer value");
                                    }
                                }
                            }

                            public String getStringValue(ByteOrder byteOrder) {
                                byteOrder = getValue(byteOrder);
                                if (byteOrder == null) {
                                    return null;
                                }
                                if (byteOrder instanceof String) {
                                    return (String) byteOrder;
                                }
                                StringBuilder stringBuilder = new StringBuilder();
                                int i = 0;
                                if (byteOrder instanceof long[]) {
                                    long[] jArr = (long[]) byteOrder;
                                    while (i < jArr.length) {
                                        stringBuilder.append(jArr[i]);
                                        i++;
                                        if (i != jArr.length) {
                                            stringBuilder.append(",");
                                        }
                                    }
                                    return stringBuilder.toString();
                                } else if (byteOrder instanceof int[]) {
                                    int[] iArr = (int[]) byteOrder;
                                    while (i < iArr.length) {
                                        stringBuilder.append(iArr[i]);
                                        i++;
                                        if (i != iArr.length) {
                                            stringBuilder.append(",");
                                        }
                                    }
                                    return stringBuilder.toString();
                                } else if (byteOrder instanceof double[]) {
                                    double[] dArr = (double[]) byteOrder;
                                    while (i < dArr.length) {
                                        stringBuilder.append(dArr[i]);
                                        i++;
                                        if (i != dArr.length) {
                                            stringBuilder.append(",");
                                        }
                                    }
                                    return stringBuilder.toString();
                                } else if (!(byteOrder instanceof Rational[])) {
                                    return null;
                                } else {
                                    Rational[] rationalArr = (Rational[]) byteOrder;
                                    while (i < rationalArr.length) {
                                        stringBuilder.append(rationalArr[i].numerator);
                                        stringBuilder.append('/');
                                        stringBuilder.append(rationalArr[i].denominator);
                                        i++;
                                        if (i != rationalArr.length) {
                                            stringBuilder.append(",");
                                        }
                                    }
                                    return stringBuilder.toString();
                                }
                            }

                            public int size() {
                                return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
                            }
                        }

                        static class ExifTag {
                            public final String name;
                            public final int number;
                            public final int primaryFormat;
                            public final int secondaryFormat;

                            private ExifTag(String str, int i, int i2) {
                                this.name = str;
                                this.number = i;
                                this.primaryFormat = i2;
                                this.secondaryFormat = -1;
                            }

                            private ExifTag(String str, int i, int i2, int i3) {
                                this.name = str;
                                this.number = i;
                                this.primaryFormat = i2;
                                this.secondaryFormat = i3;
                            }

                            private boolean isFormatCompatible(int i) {
                                if (this.primaryFormat != 7) {
                                    if (i != 7) {
                                        if (this.primaryFormat != i) {
                                            if (this.secondaryFormat != i) {
                                                if ((this.primaryFormat == 4 || this.secondaryFormat == 4) && i == 3) {
                                                    return true;
                                                }
                                                if ((this.primaryFormat == 9 || this.secondaryFormat == 9) && i == 8) {
                                                    return true;
                                                }
                                                if ((this.primaryFormat == 12 || this.secondaryFormat == 12) && i == 11) {
                                                    return true;
                                                }
                                                return false;
                                            }
                                        }
                                        return true;
                                    }
                                }
                                return true;
                            }
                        }

                        @RestrictTo({Scope.LIBRARY})
                        @Retention(RetentionPolicy.SOURCE)
                        public @interface IfdType {
                        }

                        private static class Rational {
                            public final long denominator;
                            public final long numerator;

                            private Rational(double d) {
                                this((long) (d * 10000.0d), 10000);
                            }

                            private Rational(long j, long j2) {
                                if (j2 == 0) {
                                    this.numerator = 0;
                                    this.denominator = 1;
                                    return;
                                }
                                this.numerator = j;
                                this.denominator = j2;
                            }

                            public String toString() {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(this.numerator);
                                stringBuilder.append("/");
                                stringBuilder.append(this.denominator);
                                return stringBuilder.toString();
                            }

                            public double calculate() {
                                return ((double) this.numerator) / ((double) this.denominator);
                            }
                        }

                        static {
                            sFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
                            for (int i = 0; i < EXIF_TAGS.length; i++) {
                                sExifTagMapsForReading[i] = new HashMap();
                                sExifTagMapsForWriting[i] = new HashMap();
                                for (ExifTag exifTag : EXIF_TAGS[i]) {
                                    sExifTagMapsForReading[i].put(Integer.valueOf(exifTag.number), exifTag);
                                    sExifTagMapsForWriting[i].put(exifTag.name, exifTag);
                                }
                            }
                            sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[0].number), Integer.valueOf(5));
                            sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[1].number), Integer.valueOf(1));
                            sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[2].number), Integer.valueOf(2));
                            sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[3].number), Integer.valueOf(3));
                            sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[4].number), Integer.valueOf(7));
                            sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[5].number), Integer.valueOf(8));
                        }

                        public ExifInterface(@NonNull String str) throws IOException {
                            this.mAttributes = new HashMap[EXIF_TAGS.length];
                            this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
                            if (str != null) {
                                Closeable closeable = null;
                                this.mAssetInputStream = null;
                                this.mFilename = str;
                                try {
                                    Closeable fileInputStream = new FileInputStream(str);
                                    try {
                                        loadAttributes(fileInputStream);
                                        closeQuietly(fileInputStream);
                                        return;
                                    } catch (Throwable th) {
                                        str = th;
                                        closeable = fileInputStream;
                                        closeQuietly(closeable);
                                        throw str;
                                    }
                                } catch (Throwable th2) {
                                    str = th2;
                                    closeQuietly(closeable);
                                    throw str;
                                }
                            }
                            throw new IllegalArgumentException("filename cannot be null");
                        }

                        public ExifInterface(@NonNull InputStream inputStream) throws IOException {
                            this.mAttributes = new HashMap[EXIF_TAGS.length];
                            this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
                            if (inputStream != null) {
                                this.mFilename = null;
                                if (inputStream instanceof AssetInputStream) {
                                    this.mAssetInputStream = (AssetInputStream) inputStream;
                                } else {
                                    this.mAssetInputStream = null;
                                }
                                loadAttributes(inputStream);
                                return;
                            }
                            throw new IllegalArgumentException("inputStream cannot be null");
                        }

                        @Nullable
                        private ExifAttribute getExifAttribute(@NonNull String str) {
                            if (TAG_ISO_SPEED_RATINGS.equals(str)) {
                                str = TAG_PHOTOGRAPHIC_SENSITIVITY;
                            }
                            for (int i = 0; i < EXIF_TAGS.length; i++) {
                                ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes[i].get(str);
                                if (exifAttribute != null) {
                                    return exifAttribute;
                                }
                            }
                            return null;
                        }

                        @android.support.annotation.Nullable
                        public java.lang.String getAttribute(@android.support.annotation.NonNull java.lang.String r7) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r6 = this;
                            r0 = r6.getExifAttribute(r7);
                            r1 = 0;
                            if (r0 == 0) goto L_0x00ba;
                        L_0x0007:
                            r2 = sTagSetForCompatibility;
                            r2 = r2.contains(r7);
                            if (r2 != 0) goto L_0x0016;
                        L_0x000f:
                            r7 = r6.mExifByteOrder;
                            r7 = r0.getStringValue(r7);
                            return r7;
                        L_0x0016:
                            r2 = "GPSTimeStamp";
                            r7 = r7.equals(r2);
                            if (r7 == 0) goto L_0x00ae;
                        L_0x001e:
                            r7 = r0.format;
                            r2 = 5;
                            if (r7 == r2) goto L_0x0042;
                        L_0x0023:
                            r7 = r0.format;
                            r2 = 10;
                            if (r7 == r2) goto L_0x0042;
                        L_0x0029:
                            r7 = "ExifInterface";
                            r2 = new java.lang.StringBuilder;
                            r2.<init>();
                            r3 = "GPS Timestamp format is not rational. format=";
                            r2.append(r3);
                            r0 = r0.format;
                            r2.append(r0);
                            r0 = r2.toString();
                            android.util.Log.w(r7, r0);
                            return r1;
                        L_0x0042:
                            r7 = r6.mExifByteOrder;
                            r7 = r0.getValue(r7);
                            r7 = (android.support.media.ExifInterface.Rational[]) r7;
                            if (r7 == 0) goto L_0x0093;
                        L_0x004c:
                            r0 = 3;
                            r2 = r7.length;
                            if (r2 == r0) goto L_0x0051;
                        L_0x0050:
                            goto L_0x0093;
                        L_0x0051:
                            r1 = "%02d:%02d:%02d";
                            r0 = new java.lang.Object[r0];
                            r2 = 0;
                            r3 = r7[r2];
                            r3 = r3.numerator;
                            r3 = (float) r3;
                            r4 = r7[r2];
                            r4 = r4.denominator;
                            r4 = (float) r4;
                            r3 = r3 / r4;
                            r3 = (int) r3;
                            r3 = java.lang.Integer.valueOf(r3);
                            r0[r2] = r3;
                            r2 = 1;
                            r3 = r7[r2];
                            r3 = r3.numerator;
                            r3 = (float) r3;
                            r4 = r7[r2];
                            r4 = r4.denominator;
                            r4 = (float) r4;
                            r3 = r3 / r4;
                            r3 = (int) r3;
                            r3 = java.lang.Integer.valueOf(r3);
                            r0[r2] = r3;
                            r2 = 2;
                            r3 = r7[r2];
                            r3 = r3.numerator;
                            r3 = (float) r3;
                            r7 = r7[r2];
                            r4 = r7.denominator;
                            r7 = (float) r4;
                            r3 = r3 / r7;
                            r7 = (int) r3;
                            r7 = java.lang.Integer.valueOf(r7);
                            r0[r2] = r7;
                            r7 = java.lang.String.format(r1, r0);
                            return r7;
                        L_0x0093:
                            r0 = "ExifInterface";
                            r2 = new java.lang.StringBuilder;
                            r2.<init>();
                            r3 = "Invalid GPS Timestamp array. array=";
                            r2.append(r3);
                            r7 = java.util.Arrays.toString(r7);
                            r2.append(r7);
                            r7 = r2.toString();
                            android.util.Log.w(r0, r7);
                            return r1;
                        L_0x00ae:
                            r7 = r6.mExifByteOrder;	 Catch:{ NumberFormatException -> 0x00b9 }
                            r2 = r0.getDoubleValue(r7);	 Catch:{ NumberFormatException -> 0x00b9 }
                            r7 = java.lang.Double.toString(r2);	 Catch:{ NumberFormatException -> 0x00b9 }
                            return r7;
                        L_0x00b9:
                            return r1;
                        L_0x00ba:
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.media.ExifInterface.getAttribute(java.lang.String):java.lang.String");
                        }

                        public int getAttributeInt(@android.support.annotation.NonNull java.lang.String r2, int r3) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r2 = r1.getExifAttribute(r2);
                            if (r2 != 0) goto L_0x0007;
                        L_0x0006:
                            return r3;
                        L_0x0007:
                            r0 = r1.mExifByteOrder;	 Catch:{ NumberFormatException -> 0x000e }
                            r2 = r2.getIntValue(r0);	 Catch:{ NumberFormatException -> 0x000e }
                            return r2;
                        L_0x000e:
                            return r3;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.media.ExifInterface.getAttributeInt(java.lang.String, int):int");
                        }

                        public double getAttributeDouble(@android.support.annotation.NonNull java.lang.String r3, double r4) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r3 = r2.getExifAttribute(r3);
                            if (r3 != 0) goto L_0x0007;
                        L_0x0006:
                            return r4;
                        L_0x0007:
                            r0 = r2.mExifByteOrder;	 Catch:{ NumberFormatException -> 0x000e }
                            r0 = r3.getDoubleValue(r0);	 Catch:{ NumberFormatException -> 0x000e }
                            return r0;
                        L_0x000e:
                            return r4;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.media.ExifInterface.getAttributeDouble(java.lang.String, double):double");
                        }

                        public void setAttribute(@android.support.annotation.NonNull java.lang.String r19, @android.support.annotation.Nullable java.lang.String r20) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r18 = this;
                            r0 = r18;
                            r1 = r20;
                            r2 = "ISOSpeedRatings";
                            r3 = r19;
                            r2 = r2.equals(r3);
                            if (r2 == 0) goto L_0x0011;
                        L_0x000e:
                            r2 = "PhotographicSensitivity";
                            goto L_0x0012;
                        L_0x0011:
                            r2 = r3;
                        L_0x0012:
                            r3 = 2;
                            r4 = 1;
                            if (r1 == 0) goto L_0x00bb;
                        L_0x0016:
                            r5 = sTagSetForCompatibility;
                            r5 = r5.contains(r2);
                            if (r5 == 0) goto L_0x00bb;
                        L_0x001e:
                            r5 = "GPSTimeStamp";
                            r5 = r2.equals(r5);
                            if (r5 == 0) goto L_0x008c;
                        L_0x0026:
                            r5 = sGpsTimestampPattern;
                            r5 = r5.matcher(r1);
                            r6 = r5.find();
                            if (r6 != 0) goto L_0x0051;
                        L_0x0032:
                            r3 = "ExifInterface";
                            r4 = new java.lang.StringBuilder;
                            r4.<init>();
                            r5 = "Invalid value for ";
                            r4.append(r5);
                            r4.append(r2);
                            r2 = " : ";
                            r4.append(r2);
                            r4.append(r1);
                            r1 = r4.toString();
                            android.util.Log.w(r3, r1);
                            return;
                        L_0x0051:
                            r1 = new java.lang.StringBuilder;
                            r1.<init>();
                            r6 = r5.group(r4);
                            r6 = java.lang.Integer.parseInt(r6);
                            r1.append(r6);
                            r6 = "/1,";
                            r1.append(r6);
                            r6 = r5.group(r3);
                            r6 = java.lang.Integer.parseInt(r6);
                            r1.append(r6);
                            r6 = "/1,";
                            r1.append(r6);
                            r6 = 3;
                            r5 = r5.group(r6);
                            r5 = java.lang.Integer.parseInt(r5);
                            r1.append(r5);
                            r5 = "/1";
                            r1.append(r5);
                            r1 = r1.toString();
                            goto L_0x00bb;
                        L_0x008c:
                            r5 = java.lang.Double.parseDouble(r20);	 Catch:{ NumberFormatException -> 0x009c }
                            r7 = new android.support.media.ExifInterface$Rational;	 Catch:{ NumberFormatException -> 0x009c }
                            r8 = 0;	 Catch:{ NumberFormatException -> 0x009c }
                            r7.<init>(r5);	 Catch:{ NumberFormatException -> 0x009c }
                            r5 = r7.toString();	 Catch:{ NumberFormatException -> 0x009c }
                            r1 = r5;
                            goto L_0x00bb;
                        L_0x009c:
                            r3 = "ExifInterface";
                            r4 = new java.lang.StringBuilder;
                            r4.<init>();
                            r5 = "Invalid value for ";
                            r4.append(r5);
                            r4.append(r2);
                            r2 = " : ";
                            r4.append(r2);
                            r4.append(r1);
                            r1 = r4.toString();
                            android.util.Log.w(r3, r1);
                            return;
                        L_0x00bb:
                            r5 = 0;
                            r6 = r5;
                        L_0x00bd:
                            r7 = EXIF_TAGS;
                            r7 = r7.length;
                            if (r6 >= r7) goto L_0x0316;
                        L_0x00c2:
                            r7 = 4;
                            if (r6 != r7) goto L_0x00cb;
                        L_0x00c5:
                            r7 = r0.mHasThumbnail;
                            if (r7 != 0) goto L_0x00cb;
                        L_0x00c9:
                            goto L_0x0312;
                        L_0x00cb:
                            r7 = sExifTagMapsForWriting;
                            r7 = r7[r6];
                            r7 = r7.get(r2);
                            r7 = (android.support.media.ExifInterface.ExifTag) r7;
                            if (r7 == 0) goto L_0x0312;
                        L_0x00d7:
                            if (r1 != 0) goto L_0x00e2;
                        L_0x00d9:
                            r7 = r0.mAttributes;
                            r7 = r7[r6];
                            r7.remove(r2);
                            goto L_0x0312;
                        L_0x00e2:
                            r8 = guessDataFormat(r1);
                            r9 = r7.primaryFormat;
                            r10 = r8.first;
                            r10 = (java.lang.Integer) r10;
                            r10 = r10.intValue();
                            if (r9 == r10) goto L_0x01c5;
                        L_0x00f2:
                            r9 = r7.primaryFormat;
                            r10 = r8.second;
                            r10 = (java.lang.Integer) r10;
                            r10 = r10.intValue();
                            if (r9 != r10) goto L_0x0100;
                        L_0x00fe:
                            goto L_0x01c5;
                        L_0x0100:
                            r9 = r7.secondaryFormat;
                            r10 = -1;
                            if (r9 == r10) goto L_0x0121;
                        L_0x0105:
                            r9 = r7.secondaryFormat;
                            r11 = r8.first;
                            r11 = (java.lang.Integer) r11;
                            r11 = r11.intValue();
                            if (r9 == r11) goto L_0x011d;
                        L_0x0111:
                            r9 = r7.secondaryFormat;
                            r11 = r8.second;
                            r11 = (java.lang.Integer) r11;
                            r11 = r11.intValue();
                            if (r9 != r11) goto L_0x0121;
                        L_0x011d:
                            r7 = r7.secondaryFormat;
                            goto L_0x01c7;
                        L_0x0121:
                            r9 = r7.primaryFormat;
                            if (r9 == r4) goto L_0x01c2;
                        L_0x0125:
                            r9 = r7.primaryFormat;
                            r11 = 7;
                            if (r9 == r11) goto L_0x01c2;
                        L_0x012a:
                            r9 = r7.primaryFormat;
                            if (r9 != r3) goto L_0x0130;
                        L_0x012e:
                            goto L_0x01c2;
                        L_0x0130:
                            r9 = "ExifInterface";
                            r11 = new java.lang.StringBuilder;
                            r11.<init>();
                            r12 = "Given tag (";
                            r11.append(r12);
                            r11.append(r2);
                            r12 = ") value didn't match with one of expected ";
                            r11.append(r12);
                            r12 = "formats: ";
                            r11.append(r12);
                            r12 = IFD_FORMAT_NAMES;
                            r13 = r7.primaryFormat;
                            r12 = r12[r13];
                            r11.append(r12);
                            r12 = r7.secondaryFormat;
                            if (r12 != r10) goto L_0x0159;
                        L_0x0156:
                            r7 = "";
                            goto L_0x0170;
                        L_0x0159:
                            r12 = new java.lang.StringBuilder;
                            r12.<init>();
                            r13 = ", ";
                            r12.append(r13);
                            r13 = IFD_FORMAT_NAMES;
                            r7 = r7.secondaryFormat;
                            r7 = r13[r7];
                            r12.append(r7);
                            r7 = r12.toString();
                        L_0x0170:
                            r11.append(r7);
                            r7 = " (guess: ";
                            r11.append(r7);
                            r7 = IFD_FORMAT_NAMES;
                            r12 = r8.first;
                            r12 = (java.lang.Integer) r12;
                            r12 = r12.intValue();
                            r7 = r7[r12];
                            r11.append(r7);
                            r7 = r8.second;
                            r7 = (java.lang.Integer) r7;
                            r7 = r7.intValue();
                            if (r7 != r10) goto L_0x0194;
                        L_0x0191:
                            r7 = "";
                            goto L_0x01b1;
                        L_0x0194:
                            r7 = new java.lang.StringBuilder;
                            r7.<init>();
                            r10 = ", ";
                            r7.append(r10);
                            r10 = IFD_FORMAT_NAMES;
                            r8 = r8.second;
                            r8 = (java.lang.Integer) r8;
                            r8 = r8.intValue();
                            r8 = r10[r8];
                            r7.append(r8);
                            r7 = r7.toString();
                        L_0x01b1:
                            r11.append(r7);
                            r7 = ")";
                            r11.append(r7);
                            r7 = r11.toString();
                            android.util.Log.w(r9, r7);
                            goto L_0x0312;
                        L_0x01c2:
                            r7 = r7.primaryFormat;
                            goto L_0x01c7;
                        L_0x01c5:
                            r7 = r7.primaryFormat;
                        L_0x01c7:
                            switch(r7) {
                                case 1: goto L_0x0307;
                                case 2: goto L_0x02fb;
                                case 3: goto L_0x02d5;
                                case 4: goto L_0x02af;
                                case 5: goto L_0x0270;
                                case 6: goto L_0x01ca;
                                case 7: goto L_0x02fb;
                                case 8: goto L_0x01ca;
                                case 9: goto L_0x0249;
                                case 10: goto L_0x0209;
                                case 11: goto L_0x01ca;
                                case 12: goto L_0x01e2;
                                default: goto L_0x01ca;
                            };
                        L_0x01ca:
                            r8 = "ExifInterface";
                            r9 = new java.lang.StringBuilder;
                            r9.<init>();
                            r10 = "Data format isn't one of expected formats: ";
                            r9.append(r10);
                            r9.append(r7);
                            r7 = r9.toString();
                            android.util.Log.w(r8, r7);
                            goto L_0x0312;
                        L_0x01e2:
                            r7 = ",";
                            r7 = r1.split(r7);
                            r8 = r7.length;
                            r8 = new double[r8];
                            r9 = r5;
                        L_0x01ec:
                            r10 = r7.length;
                            if (r9 >= r10) goto L_0x01fa;
                        L_0x01ef:
                            r10 = r7[r9];
                            r10 = java.lang.Double.parseDouble(r10);
                            r8[r9] = r10;
                            r9 = r9 + 1;
                            goto L_0x01ec;
                        L_0x01fa:
                            r7 = r0.mAttributes;
                            r7 = r7[r6];
                            r9 = r0.mExifByteOrder;
                            r8 = android.support.media.ExifInterface.ExifAttribute.createDouble(r8, r9);
                            r7.put(r2, r8);
                            goto L_0x0312;
                        L_0x0209:
                            r7 = ",";
                            r7 = r1.split(r7);
                            r8 = r7.length;
                            r8 = new android.support.media.ExifInterface.Rational[r8];
                            r9 = r5;
                        L_0x0213:
                            r10 = r7.length;
                            if (r9 >= r10) goto L_0x023a;
                        L_0x0216:
                            r10 = r7[r9];
                            r11 = "/";
                            r10 = r10.split(r11);
                            r17 = new android.support.media.ExifInterface$Rational;
                            r11 = r10[r5];
                            r11 = java.lang.Double.parseDouble(r11);
                            r12 = (long) r11;
                            r10 = r10[r4];
                            r10 = java.lang.Double.parseDouble(r10);
                            r14 = (long) r10;
                            r16 = 0;
                            r11 = r17;
                            r11.<init>(r12, r14);
                            r8[r9] = r17;
                            r9 = r9 + 1;
                            goto L_0x0213;
                        L_0x023a:
                            r7 = r0.mAttributes;
                            r7 = r7[r6];
                            r9 = r0.mExifByteOrder;
                            r8 = android.support.media.ExifInterface.ExifAttribute.createSRational(r8, r9);
                            r7.put(r2, r8);
                            goto L_0x0312;
                        L_0x0249:
                            r7 = ",";
                            r7 = r1.split(r7);
                            r8 = r7.length;
                            r8 = new int[r8];
                            r9 = r5;
                        L_0x0253:
                            r10 = r7.length;
                            if (r9 >= r10) goto L_0x0261;
                        L_0x0256:
                            r10 = r7[r9];
                            r10 = java.lang.Integer.parseInt(r10);
                            r8[r9] = r10;
                            r9 = r9 + 1;
                            goto L_0x0253;
                        L_0x0261:
                            r7 = r0.mAttributes;
                            r7 = r7[r6];
                            r9 = r0.mExifByteOrder;
                            r8 = android.support.media.ExifInterface.ExifAttribute.createSLong(r8, r9);
                            r7.put(r2, r8);
                            goto L_0x0312;
                        L_0x0270:
                            r7 = ",";
                            r7 = r1.split(r7);
                            r8 = r7.length;
                            r8 = new android.support.media.ExifInterface.Rational[r8];
                            r9 = r5;
                        L_0x027a:
                            r10 = r7.length;
                            if (r9 >= r10) goto L_0x02a1;
                        L_0x027d:
                            r10 = r7[r9];
                            r11 = "/";
                            r10 = r10.split(r11);
                            r17 = new android.support.media.ExifInterface$Rational;
                            r11 = r10[r5];
                            r11 = java.lang.Double.parseDouble(r11);
                            r12 = (long) r11;
                            r10 = r10[r4];
                            r10 = java.lang.Double.parseDouble(r10);
                            r14 = (long) r10;
                            r16 = 0;
                            r11 = r17;
                            r11.<init>(r12, r14);
                            r8[r9] = r17;
                            r9 = r9 + 1;
                            goto L_0x027a;
                        L_0x02a1:
                            r7 = r0.mAttributes;
                            r7 = r7[r6];
                            r9 = r0.mExifByteOrder;
                            r8 = android.support.media.ExifInterface.ExifAttribute.createURational(r8, r9);
                            r7.put(r2, r8);
                            goto L_0x0312;
                        L_0x02af:
                            r7 = ",";
                            r7 = r1.split(r7);
                            r8 = r7.length;
                            r8 = new long[r8];
                            r9 = r5;
                        L_0x02b9:
                            r10 = r7.length;
                            if (r9 >= r10) goto L_0x02c7;
                        L_0x02bc:
                            r10 = r7[r9];
                            r10 = java.lang.Long.parseLong(r10);
                            r8[r9] = r10;
                            r9 = r9 + 1;
                            goto L_0x02b9;
                        L_0x02c7:
                            r7 = r0.mAttributes;
                            r7 = r7[r6];
                            r9 = r0.mExifByteOrder;
                            r8 = android.support.media.ExifInterface.ExifAttribute.createULong(r8, r9);
                            r7.put(r2, r8);
                            goto L_0x0312;
                        L_0x02d5:
                            r7 = ",";
                            r7 = r1.split(r7);
                            r8 = r7.length;
                            r8 = new int[r8];
                            r9 = r5;
                        L_0x02df:
                            r10 = r7.length;
                            if (r9 >= r10) goto L_0x02ed;
                        L_0x02e2:
                            r10 = r7[r9];
                            r10 = java.lang.Integer.parseInt(r10);
                            r8[r9] = r10;
                            r9 = r9 + 1;
                            goto L_0x02df;
                        L_0x02ed:
                            r7 = r0.mAttributes;
                            r7 = r7[r6];
                            r9 = r0.mExifByteOrder;
                            r8 = android.support.media.ExifInterface.ExifAttribute.createUShort(r8, r9);
                            r7.put(r2, r8);
                            goto L_0x0312;
                        L_0x02fb:
                            r7 = r0.mAttributes;
                            r7 = r7[r6];
                            r8 = android.support.media.ExifInterface.ExifAttribute.createString(r1);
                            r7.put(r2, r8);
                            goto L_0x0312;
                        L_0x0307:
                            r7 = r0.mAttributes;
                            r7 = r7[r6];
                            r8 = android.support.media.ExifInterface.ExifAttribute.createByte(r1);
                            r7.put(r2, r8);
                        L_0x0312:
                            r6 = r6 + 1;
                            goto L_0x00bd;
                        L_0x0316:
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.media.ExifInterface.setAttribute(java.lang.String, java.lang.String):void");
                        }

                        public void resetOrientation() {
                            setAttribute(TAG_ORIENTATION, Integer.toString(1));
                        }

                        public void rotate(int i) {
                            if (i % 90 == 0) {
                                int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
                                int i2 = 0;
                                if (ROTATION_ORDER.contains(Integer.valueOf(attributeInt))) {
                                    attributeInt = (ROTATION_ORDER.indexOf(Integer.valueOf(attributeInt)) + (i / 90)) % 4;
                                    if (attributeInt < 0) {
                                        i2 = 4;
                                    }
                                    i2 = ((Integer) ROTATION_ORDER.get(attributeInt + i2)).intValue();
                                } else if (FLIPPED_ROTATION_ORDER.contains(Integer.valueOf(attributeInt))) {
                                    attributeInt = (FLIPPED_ROTATION_ORDER.indexOf(Integer.valueOf(attributeInt)) + (i / 90)) % 4;
                                    if (attributeInt < 0) {
                                        i2 = 4;
                                    }
                                    i2 = ((Integer) FLIPPED_ROTATION_ORDER.get(attributeInt + i2)).intValue();
                                }
                                setAttribute(TAG_ORIENTATION, Integer.toString(i2));
                                return;
                            }
                            throw new IllegalArgumentException("degree should be a multiple of 90");
                        }

                        public void flipVertically() {
                            int i = 1;
                            switch (getAttributeInt(TAG_ORIENTATION, 1)) {
                                case 1:
                                    i = 4;
                                    break;
                                case 2:
                                    i = 3;
                                    break;
                                case 3:
                                    i = 2;
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    i = 8;
                                    break;
                                case 6:
                                    i = 7;
                                    break;
                                case 7:
                                    i = 6;
                                    break;
                                case 8:
                                    i = 5;
                                    break;
                                default:
                                    i = 0;
                                    break;
                            }
                            setAttribute(TAG_ORIENTATION, Integer.toString(i));
                        }

                        public void flipHorizontally() {
                            int i = 1;
                            switch (getAttributeInt(TAG_ORIENTATION, 1)) {
                                case 1:
                                    i = 2;
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    i = 4;
                                    break;
                                case 4:
                                    i = 3;
                                    break;
                                case 5:
                                    i = 6;
                                    break;
                                case 6:
                                    i = 5;
                                    break;
                                case 7:
                                    i = 8;
                                    break;
                                case 8:
                                    i = 7;
                                    break;
                                default:
                                    i = 0;
                                    break;
                            }
                            setAttribute(TAG_ORIENTATION, Integer.toString(i));
                        }

                        public boolean isFlipped() {
                            int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
                            if (!(attributeInt == 2 || attributeInt == 7)) {
                                switch (attributeInt) {
                                    case 4:
                                    case 5:
                                        break;
                                    default:
                                        return false;
                                }
                            }
                            return true;
                        }

                        public int getRotationDegrees() {
                            switch (getAttributeInt(TAG_ORIENTATION, 1)) {
                                case 3:
                                case 4:
                                    return 180;
                                case 5:
                                case 8:
                                    return 270;
                                case 6:
                                case 7:
                                    return 90;
                                default:
                                    return 0;
                            }
                        }

                        private boolean updateAttribute(String str, ExifAttribute exifAttribute) {
                            int i = 0;
                            boolean z = false;
                            while (i < EXIF_TAGS.length) {
                                if (this.mAttributes[i].containsKey(str)) {
                                    this.mAttributes[i].put(str, exifAttribute);
                                    z = true;
                                }
                                i++;
                            }
                            return z;
                        }

                        private void removeAttribute(String str) {
                            for (int i = 0; i < EXIF_TAGS.length; i++) {
                                this.mAttributes[i].remove(str);
                            }
                        }

                        private void loadAttributes(@android.support.annotation.NonNull java.io.InputStream r5) throws java.io.IOException {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r4 = this;
                            r0 = 0;
                            r1 = r0;
                        L_0x0002:
                            r2 = EXIF_TAGS;	 Catch:{ IOException -> 0x004a }
                            r2 = r2.length;	 Catch:{ IOException -> 0x004a }
                            if (r1 >= r2) goto L_0x0013;	 Catch:{ IOException -> 0x004a }
                        L_0x0007:
                            r2 = r4.mAttributes;	 Catch:{ IOException -> 0x004a }
                            r3 = new java.util.HashMap;	 Catch:{ IOException -> 0x004a }
                            r3.<init>();	 Catch:{ IOException -> 0x004a }
                            r2[r1] = r3;	 Catch:{ IOException -> 0x004a }
                            r1 = r1 + 1;	 Catch:{ IOException -> 0x004a }
                            goto L_0x0002;	 Catch:{ IOException -> 0x004a }
                        L_0x0013:
                            r1 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x004a }
                            r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;	 Catch:{ IOException -> 0x004a }
                            r1.<init>(r5, r2);	 Catch:{ IOException -> 0x004a }
                            r5 = r1;	 Catch:{ IOException -> 0x004a }
                            r5 = (java.io.BufferedInputStream) r5;	 Catch:{ IOException -> 0x004a }
                            r5 = r4.getMimeType(r5);	 Catch:{ IOException -> 0x004a }
                            r4.mMimeType = r5;	 Catch:{ IOException -> 0x004a }
                            r5 = new android.support.media.ExifInterface$ByteOrderedDataInputStream;	 Catch:{ IOException -> 0x004a }
                            r5.<init>(r1);	 Catch:{ IOException -> 0x004a }
                            r1 = r4.mMimeType;	 Catch:{ IOException -> 0x004a }
                            switch(r1) {
                                case 0: goto L_0x003e;
                                case 1: goto L_0x003e;
                                case 2: goto L_0x003e;
                                case 3: goto L_0x003e;
                                case 4: goto L_0x003a;
                                case 5: goto L_0x003e;
                                case 6: goto L_0x003e;
                                case 7: goto L_0x0036;
                                case 8: goto L_0x003e;
                                case 9: goto L_0x0032;
                                case 10: goto L_0x002e;
                                case 11: goto L_0x003e;
                                default: goto L_0x002d;
                            };	 Catch:{ IOException -> 0x004a }
                        L_0x002d:
                            goto L_0x0041;	 Catch:{ IOException -> 0x004a }
                        L_0x002e:
                            r4.getRw2Attributes(r5);	 Catch:{ IOException -> 0x004a }
                            goto L_0x0041;	 Catch:{ IOException -> 0x004a }
                        L_0x0032:
                            r4.getRafAttributes(r5);	 Catch:{ IOException -> 0x004a }
                            goto L_0x0041;	 Catch:{ IOException -> 0x004a }
                        L_0x0036:
                            r4.getOrfAttributes(r5);	 Catch:{ IOException -> 0x004a }
                            goto L_0x0041;	 Catch:{ IOException -> 0x004a }
                        L_0x003a:
                            r4.getJpegAttributes(r5, r0, r0);	 Catch:{ IOException -> 0x004a }
                            goto L_0x0041;	 Catch:{ IOException -> 0x004a }
                        L_0x003e:
                            r4.getRawAttributes(r5);	 Catch:{ IOException -> 0x004a }
                        L_0x0041:
                            r4.setThumbnailData(r5);	 Catch:{ IOException -> 0x004a }
                            r5 = 1;	 Catch:{ IOException -> 0x004a }
                            r4.mIsSupportedFile = r5;	 Catch:{ IOException -> 0x004a }
                            goto L_0x004c;
                        L_0x0048:
                            r5 = move-exception;
                            goto L_0x0050;
                        L_0x004a:
                            r4.mIsSupportedFile = r0;	 Catch:{ all -> 0x0048 }
                        L_0x004c:
                            r4.addDefaultValuesForCompatibility();
                            return;
                        L_0x0050:
                            r4.addDefaultValuesForCompatibility();
                            throw r5;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.media.ExifInterface.loadAttributes(java.io.InputStream):void");
                        }

                        private void printAttributes() {
                            for (int i = 0; i < this.mAttributes.length; i++) {
                                String str = TAG;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("The size of tag group[");
                                stringBuilder.append(i);
                                stringBuilder.append("]: ");
                                stringBuilder.append(this.mAttributes[i].size());
                                Log.d(str, stringBuilder.toString());
                                for (Entry entry : this.mAttributes[i].entrySet()) {
                                    ExifAttribute exifAttribute = (ExifAttribute) entry.getValue();
                                    String str2 = TAG;
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("tagName: ");
                                    stringBuilder2.append((String) entry.getKey());
                                    stringBuilder2.append(", tagType: ");
                                    stringBuilder2.append(exifAttribute.toString());
                                    stringBuilder2.append(", tagValue: '");
                                    stringBuilder2.append(exifAttribute.getStringValue(this.mExifByteOrder));
                                    stringBuilder2.append("'");
                                    Log.d(str2, stringBuilder2.toString());
                                }
                            }
                        }

                        public void saveAttributes() throws IOException {
                            Closeable fileInputStream;
                            Closeable fileOutputStream;
                            Throwable th;
                            if (!this.mIsSupportedFile || this.mMimeType != 4) {
                                throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
                            } else if (this.mFilename != null) {
                                this.mThumbnailBytes = getThumbnail();
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(this.mFilename);
                                stringBuilder.append(".tmp");
                                File file = new File(stringBuilder.toString());
                                if (new File(this.mFilename).renameTo(file)) {
                                    Closeable closeable = null;
                                    try {
                                        fileInputStream = new FileInputStream(file);
                                        try {
                                            fileOutputStream = new FileOutputStream(this.mFilename);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            closeQuietly(fileInputStream);
                                            closeQuietly(closeable);
                                            file.delete();
                                            throw th;
                                        }
                                        try {
                                            saveJpegAttributes(fileInputStream, fileOutputStream);
                                            closeQuietly(fileInputStream);
                                            closeQuietly(fileOutputStream);
                                            file.delete();
                                            this.mThumbnailBytes = null;
                                            return;
                                        } catch (Throwable th3) {
                                            Closeable closeable2 = fileOutputStream;
                                            th = th3;
                                            closeable = closeable2;
                                            closeQuietly(fileInputStream);
                                            closeQuietly(closeable);
                                            file.delete();
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        fileInputStream = null;
                                        closeQuietly(fileInputStream);
                                        closeQuietly(closeable);
                                        file.delete();
                                        throw th;
                                    }
                                }
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("Could not rename to ");
                                stringBuilder2.append(file.getAbsolutePath());
                                throw new IOException(stringBuilder2.toString());
                            } else {
                                throw new IOException("ExifInterface does not support saving attributes for the current input.");
                            }
                        }

                        public boolean hasThumbnail() {
                            return this.mHasThumbnail;
                        }

                        @Nullable
                        public byte[] getThumbnail() {
                            if (this.mThumbnailCompression != 6) {
                                if (this.mThumbnailCompression != 7) {
                                    return null;
                                }
                            }
                            return getThumbnailBytes();
                        }

                        @Nullable
                        public byte[] getThumbnailBytes() {
                            Closeable closeable;
                            Throwable e;
                            Throwable th;
                            if (!this.mHasThumbnail) {
                                return null;
                            }
                            if (this.mThumbnailBytes != null) {
                                return this.mThumbnailBytes;
                            }
                            try {
                                if (this.mAssetInputStream != null) {
                                    closeable = this.mAssetInputStream;
                                    try {
                                        if (closeable.markSupported()) {
                                            closeable.reset();
                                        } else {
                                            Log.d(TAG, "Cannot read thumbnail from inputstream without mark/reset support");
                                            closeQuietly(closeable);
                                            return null;
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        try {
                                            Log.d(TAG, "Encountered exception while getting thumbnail", e);
                                            closeQuietly(closeable);
                                            return null;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            closeQuietly(closeable);
                                            throw th;
                                        }
                                    }
                                }
                                closeable = this.mFilename != null ? new FileInputStream(this.mFilename) : null;
                                if (closeable == null) {
                                    throw new FileNotFoundException();
                                } else if (closeable.skip((long) this.mThumbnailOffset) == ((long) this.mThumbnailOffset)) {
                                    byte[] bArr = new byte[this.mThumbnailLength];
                                    if (closeable.read(bArr) == this.mThumbnailLength) {
                                        this.mThumbnailBytes = bArr;
                                        closeQuietly(closeable);
                                        return bArr;
                                    }
                                    throw new IOException("Corrupted image");
                                } else {
                                    throw new IOException("Corrupted image");
                                }
                            } catch (IOException e3) {
                                e = e3;
                                closeable = null;
                                Log.d(TAG, "Encountered exception while getting thumbnail", e);
                                closeQuietly(closeable);
                                return null;
                            } catch (Throwable th3) {
                                th = th3;
                                closeable = null;
                                closeQuietly(closeable);
                                throw th;
                            }
                        }

                        @Nullable
                        public Bitmap getThumbnailBitmap() {
                            if (!this.mHasThumbnail) {
                                return null;
                            }
                            if (this.mThumbnailBytes == null) {
                                this.mThumbnailBytes = getThumbnailBytes();
                            }
                            if (this.mThumbnailCompression != 6) {
                                if (this.mThumbnailCompression != 7) {
                                    if (this.mThumbnailCompression == 1) {
                                        int[] iArr = new int[(this.mThumbnailBytes.length / 3)];
                                        for (int i = 0; i < iArr.length; i++) {
                                            int i2 = 3 * i;
                                            iArr[i] = (((this.mThumbnailBytes[i2] << 16) + 0) + (this.mThumbnailBytes[i2 + 1] << 8)) + this.mThumbnailBytes[i2 + 2];
                                        }
                                        ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes[4].get(TAG_IMAGE_LENGTH);
                                        ExifAttribute exifAttribute2 = (ExifAttribute) this.mAttributes[4].get(TAG_IMAGE_WIDTH);
                                        if (!(exifAttribute == null || exifAttribute2 == null)) {
                                            return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), Config.ARGB_8888);
                                        }
                                    }
                                    return null;
                                }
                            }
                            return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
                        }

                        public boolean isThumbnailCompressed() {
                            if (this.mThumbnailCompression != 6) {
                                if (this.mThumbnailCompression != 7) {
                                    return false;
                                }
                            }
                            return true;
                        }

                        @Nullable
                        public long[] getThumbnailRange() {
                            if (!this.mHasThumbnail) {
                                return null;
                            }
                            return new long[]{(long) this.mThumbnailOffset, (long) this.mThumbnailLength};
                        }

                        @Deprecated
                        public boolean getLatLong(float[] fArr) {
                            double[] latLong = getLatLong();
                            if (latLong == null) {
                                return false;
                            }
                            fArr[0] = (float) latLong[0];
                            fArr[1] = (float) latLong[1];
                            return true;
                        }

                        @android.support.annotation.Nullable
                        public double[] getLatLong() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r12 = this;
                            r0 = "GPSLatitude";
                            r0 = r12.getAttribute(r0);
                            r1 = "GPSLatitudeRef";
                            r1 = r12.getAttribute(r1);
                            r2 = "GPSLongitude";
                            r2 = r12.getAttribute(r2);
                            r3 = "GPSLongitudeRef";
                            r3 = r12.getAttribute(r3);
                            if (r0 == 0) goto L_0x005a;
                        L_0x001a:
                            if (r1 == 0) goto L_0x005a;
                        L_0x001c:
                            if (r2 == 0) goto L_0x005a;
                        L_0x001e:
                            if (r3 == 0) goto L_0x005a;
                        L_0x0020:
                            r4 = 2;
                            r5 = 1;
                            r6 = 0;
                            r7 = convertRationalLatLonToDouble(r0, r1);	 Catch:{ IllegalArgumentException -> 0x0032 }
                            r9 = convertRationalLatLonToDouble(r2, r3);	 Catch:{ IllegalArgumentException -> 0x0032 }
                            r11 = new double[r4];	 Catch:{ IllegalArgumentException -> 0x0032 }
                            r11[r6] = r7;	 Catch:{ IllegalArgumentException -> 0x0032 }
                            r11[r5] = r9;	 Catch:{ IllegalArgumentException -> 0x0032 }
                            return r11;
                        L_0x0032:
                            r7 = "ExifInterface";
                            r8 = new java.lang.StringBuilder;
                            r8.<init>();
                            r9 = "Latitude/longitude values are not parseable. ";
                            r8.append(r9);
                            r9 = "latValue=%s, latRef=%s, lngValue=%s, lngRef=%s";
                            r10 = 4;
                            r10 = new java.lang.Object[r10];
                            r10[r6] = r0;
                            r10[r5] = r1;
                            r10[r4] = r2;
                            r0 = 3;
                            r10[r0] = r3;
                            r0 = java.lang.String.format(r9, r10);
                            r8.append(r0);
                            r0 = r8.toString();
                            android.util.Log.w(r7, r0);
                        L_0x005a:
                            r0 = 0;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.media.ExifInterface.getLatLong():double[]");
                        }

                        public void setGpsInfo(Location location) {
                            if (location != null) {
                                setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
                                setLatLong(location.getLatitude(), location.getLongitude());
                                setAltitude(location.getAltitude());
                                setAttribute(TAG_GPS_SPEED_REF, "K");
                                setAttribute(TAG_GPS_SPEED, new Rational((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
                                location = sFormatter.format(new Date(location.getTime())).split("\\s+");
                                setAttribute(TAG_GPS_DATESTAMP, location[0]);
                                setAttribute(TAG_GPS_TIMESTAMP, location[1]);
                            }
                        }

                        public void setLatLong(double d, double d2) {
                            if (d < -90.0d || d > 90.0d || Double.isNaN(d)) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Latitude value ");
                                stringBuilder.append(d);
                                stringBuilder.append(" is not valid.");
                                throw new IllegalArgumentException(stringBuilder.toString());
                            } else if (d2 < -180.0d || d2 > 180.0d || Double.isNaN(d2)) {
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("Longitude value ");
                                stringBuilder2.append(d2);
                                stringBuilder2.append(" is not valid.");
                                throw new IllegalArgumentException(stringBuilder2.toString());
                            } else {
                                setAttribute(TAG_GPS_LATITUDE_REF, d >= 0.0d ? "N" : LATITUDE_SOUTH);
                                setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(d)));
                                setAttribute(TAG_GPS_LONGITUDE_REF, d2 >= 0.0d ? LONGITUDE_EAST : LONGITUDE_WEST);
                                setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(d2)));
                            }
                        }

                        public double getAltitude(double d) {
                            double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
                            int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
                            if (attributeDouble < 0.0d || attributeInt < 0) {
                                return d;
                            }
                            d = 1;
                            if (attributeInt == 1) {
                                d = Double.NaN;
                            }
                            return attributeDouble * ((double) d);
                        }

                        public void setAltitude(double d) {
                            String str = d >= 0.0d ? "0" : "1";
                            setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(d)).toString());
                            setAttribute(TAG_GPS_ALTITUDE_REF, str);
                        }

                        @RestrictTo({Scope.LIBRARY})
                        public void setDateTime(long j) {
                            long j2 = j % 1000;
                            setAttribute(TAG_DATETIME, sFormatter.format(new Date(j)));
                            setAttribute(TAG_SUBSEC_TIME, Long.toString(j2));
                        }

                        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
                        public long getDateTime() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r9 = this;
                            r0 = "DateTime";
                            r0 = r9.getAttribute(r0);
                            r1 = -1;
                            if (r0 == 0) goto L_0x0046;
                        L_0x000a:
                            r3 = sNonZeroTimePattern;
                            r3 = r3.matcher(r0);
                            r3 = r3.matches();
                            if (r3 != 0) goto L_0x0017;
                        L_0x0016:
                            goto L_0x0046;
                        L_0x0017:
                            r3 = new java.text.ParsePosition;
                            r4 = 0;
                            r3.<init>(r4);
                            r4 = sFormatter;	 Catch:{ IllegalArgumentException -> 0x0045 }
                            r0 = r4.parse(r0, r3);	 Catch:{ IllegalArgumentException -> 0x0045 }
                            if (r0 != 0) goto L_0x0026;	 Catch:{ IllegalArgumentException -> 0x0045 }
                        L_0x0025:
                            return r1;	 Catch:{ IllegalArgumentException -> 0x0045 }
                        L_0x0026:
                            r3 = r0.getTime();	 Catch:{ IllegalArgumentException -> 0x0045 }
                            r0 = "SubSecTime";	 Catch:{ IllegalArgumentException -> 0x0045 }
                            r0 = r9.getAttribute(r0);	 Catch:{ IllegalArgumentException -> 0x0045 }
                            if (r0 == 0) goto L_0x0043;
                        L_0x0032:
                            r5 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0043 }
                        L_0x0036:
                            r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ NumberFormatException -> 0x0043 }
                            r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0043 }
                            if (r0 <= 0) goto L_0x0040;	 Catch:{ NumberFormatException -> 0x0043 }
                        L_0x003c:
                            r7 = 10;	 Catch:{ NumberFormatException -> 0x0043 }
                            r5 = r5 / r7;	 Catch:{ NumberFormatException -> 0x0043 }
                            goto L_0x0036;
                        L_0x0040:
                            r0 = r3 + r5;
                            goto L_0x0044;
                        L_0x0043:
                            r0 = r3;
                        L_0x0044:
                            return r0;
                        L_0x0045:
                            return r1;
                        L_0x0046:
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.media.ExifInterface.getDateTime():long");
                        }

                        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
                        public long getGpsDateTime() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r5 = this;
                            r0 = "GPSDateStamp";
                            r0 = r5.getAttribute(r0);
                            r1 = "GPSTimeStamp";
                            r1 = r5.getAttribute(r1);
                            r2 = -1;
                            if (r0 == 0) goto L_0x0054;
                        L_0x0010:
                            if (r1 == 0) goto L_0x0054;
                        L_0x0012:
                            r4 = sNonZeroTimePattern;
                            r4 = r4.matcher(r0);
                            r4 = r4.matches();
                            if (r4 != 0) goto L_0x002b;
                        L_0x001e:
                            r4 = sNonZeroTimePattern;
                            r4 = r4.matcher(r1);
                            r4 = r4.matches();
                            if (r4 != 0) goto L_0x002b;
                        L_0x002a:
                            goto L_0x0054;
                        L_0x002b:
                            r4 = new java.lang.StringBuilder;
                            r4.<init>();
                            r4.append(r0);
                            r0 = 32;
                            r4.append(r0);
                            r4.append(r1);
                            r0 = r4.toString();
                            r1 = new java.text.ParsePosition;
                            r4 = 0;
                            r1.<init>(r4);
                            r4 = sFormatter;	 Catch:{ IllegalArgumentException -> 0x0053 }
                            r0 = r4.parse(r0, r1);	 Catch:{ IllegalArgumentException -> 0x0053 }
                            if (r0 != 0) goto L_0x004e;	 Catch:{ IllegalArgumentException -> 0x0053 }
                        L_0x004d:
                            return r2;	 Catch:{ IllegalArgumentException -> 0x0053 }
                        L_0x004e:
                            r0 = r0.getTime();	 Catch:{ IllegalArgumentException -> 0x0053 }
                            return r0;
                        L_0x0053:
                            return r2;
                        L_0x0054:
                            return r2;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.media.ExifInterface.getGpsDateTime():long");
                        }

                        private static double convertRationalLatLonToDouble(java.lang.String r9, java.lang.String r10) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = ",";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r9.split(r0);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = 0;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r9[r0];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = "/";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1.split(r2);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = r1[r0];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = r2.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = java.lang.Double.parseDouble(r2);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r4 = 1;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1[r4];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = java.lang.Double.parseDouble(r1);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = r2 / r5;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r9[r4];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = "/";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1.split(r5);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = r1[r0];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = r5.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = java.lang.Double.parseDouble(r5);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1[r4];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r7 = java.lang.Double.parseDouble(r1);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = r5 / r7;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = 2;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r9[r1];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = "/";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r9.split(r1);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = r9[r0];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = r0.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = java.lang.Double.parseDouble(r0);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r9[r4];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r9.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r7 = java.lang.Double.parseDouble(r9);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = r0 / r7;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r7 = 4633641066610819072; // 0x404e000000000000 float:0.0 double:60.0;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = r5 / r7;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = r2 + r5;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r4 = 4660134898793709568; // 0x40ac200000000000 float:0.0 double:3600.0;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = r0 / r4;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = r2 + r0;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = "S";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r10.equals(r9);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            if (r9 != 0) goto L_0x0094;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x0073:
                            r9 = "W";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r10.equals(r9);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            if (r9 == 0) goto L_0x007c;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x007b:
                            goto L_0x0094;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x007c:
                            r9 = "N";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r10.equals(r9);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            if (r9 != 0) goto L_0x0093;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x0084:
                            r9 = "E";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r10.equals(r9);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            if (r9 == 0) goto L_0x008d;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x008c:
                            goto L_0x0093;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x008d:
                            r9 = new java.lang.IllegalArgumentException;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9.<init>();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            throw r9;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x0093:
                            return r2;
                        L_0x0094:
                            r9 = -r2;
                            return r9;
                        L_0x0096:
                            r9 = new java.lang.IllegalArgumentException;
                            r9.<init>();
                            throw r9;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.media.ExifInterface.convertRationalLatLonToDouble(java.lang.String, java.lang.String):double");
                        }

                        private String convertDecimalDegree(double d) {
                            long j = (long) d;
                            d -= (double) j;
                            long j2 = (long) (d * 60.0d);
                            d = Math.round(((d - (((double) j2) / 60.0d)) * 3600.0d) * 1.0E7d);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(j);
                            stringBuilder.append("/1,");
                            stringBuilder.append(j2);
                            stringBuilder.append("/1,");
                            stringBuilder.append(d);
                            stringBuilder.append("/10000000");
                            return stringBuilder.toString();
                        }

                        private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
                            bufferedInputStream.mark(SIGNATURE_CHECK_SIZE);
                            byte[] bArr = new byte[SIGNATURE_CHECK_SIZE];
                            bufferedInputStream.read(bArr);
                            bufferedInputStream.reset();
                            if (isJpegFormat(bArr) != null) {
                                return 4;
                            }
                            if (isRafFormat(bArr) != null) {
                                return 9;
                            }
                            if (isOrfFormat(bArr) != null) {
                                return 7;
                            }
                            return isRw2Format(bArr) != null ? 10 : null;
                        }

                        private static boolean isJpegFormat(byte[] bArr) throws IOException {
                            for (int i = 0; i < JPEG_SIGNATURE.length; i++) {
                                if (bArr[i] != JPEG_SIGNATURE[i]) {
                                    return false;
                                }
                            }
                            return 1;
                        }

                        private boolean isRafFormat(byte[] bArr) throws IOException {
                            byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
                            for (int i = 0; i < bytes.length; i++) {
                                if (bArr[i] != bytes[i]) {
                                    return false;
                                }
                            }
                            return 1;
                        }

                        private boolean isOrfFormat(byte[] bArr) throws IOException {
                            ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
                            this.mExifByteOrder = readByteOrder(byteOrderedDataInputStream);
                            byteOrderedDataInputStream.setByteOrder(this.mExifByteOrder);
                            bArr = byteOrderedDataInputStream.readShort();
                            byteOrderedDataInputStream.close();
                            if (bArr != 20306) {
                                if (bArr != 21330) {
                                    return null;
                                }
                            }
                            return 1;
                        }

                        private boolean isRw2Format(byte[] bArr) throws IOException {
                            ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
                            this.mExifByteOrder = readByteOrder(byteOrderedDataInputStream);
                            byteOrderedDataInputStream.setByteOrder(this.mExifByteOrder);
                            bArr = byteOrderedDataInputStream.readShort();
                            byteOrderedDataInputStream.close();
                            return bArr == 85 ? 1 : null;
                        }

                        private void getJpegAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream, int i, int i2) throws IOException {
                            byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
                            byteOrderedDataInputStream.seek((long) i);
                            byte readByte = byteOrderedDataInputStream.readByte();
                            if (readByte == MARKER) {
                                i++;
                                if (byteOrderedDataInputStream.readByte() == MARKER_SOI) {
                                    i++;
                                    while (true) {
                                        readByte = byteOrderedDataInputStream.readByte();
                                        if (readByte == MARKER) {
                                            i++;
                                            readByte = byteOrderedDataInputStream.readByte();
                                            i++;
                                            if (readByte != MARKER_EOI) {
                                                if (readByte != MARKER_SOS) {
                                                    int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort() - 2;
                                                    i += 2;
                                                    if (readUnsignedShort >= 0) {
                                                        byte[] bArr;
                                                        if (readByte == MARKER_APP1) {
                                                            if (readUnsignedShort >= 6) {
                                                                byte[] bArr2 = new byte[6];
                                                                if (byteOrderedDataInputStream.read(bArr2) == 6) {
                                                                    i += 6;
                                                                    readUnsignedShort -= 6;
                                                                    if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                                                                        if (readUnsignedShort > 0) {
                                                                            this.mExifOffset = i;
                                                                            bArr = new byte[readUnsignedShort];
                                                                            if (byteOrderedDataInputStream.read(bArr) == readUnsignedShort) {
                                                                                i += readUnsignedShort;
                                                                                readExifSegment(bArr, i2);
                                                                            } else {
                                                                                throw new IOException("Invalid exif");
                                                                            }
                                                                        }
                                                                        throw new IOException("Invalid exif");
                                                                    }
                                                                } else {
                                                                    throw new IOException("Invalid exif");
                                                                }
                                                            }
                                                            if (readUnsignedShort >= 0) {
                                                                throw new IOException("Invalid length");
                                                            } else if (byteOrderedDataInputStream.skipBytes(readUnsignedShort) == readUnsignedShort) {
                                                                throw new IOException("Invalid JPEG segment");
                                                            } else {
                                                                i += readUnsignedShort;
                                                            }
                                                        } else if (readByte != MARKER_COM) {
                                                            switch (readByte) {
                                                                case (byte) -64:
                                                                case (byte) -63:
                                                                case (byte) -62:
                                                                case (byte) -61:
                                                                    if (byteOrderedDataInputStream.skipBytes(1) == 1) {
                                                                        this.mAttributes[i2].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong((long) byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                                        this.mAttributes[i2].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong((long) byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                                        readUnsignedShort -= 5;
                                                                        break;
                                                                    }
                                                                    throw new IOException("Invalid SOFx");
                                                                default:
                                                                    switch (readByte) {
                                                                        case (byte) -59:
                                                                        case (byte) -58:
                                                                        case (byte) -57:
                                                                            break;
                                                                        default:
                                                                            switch (readByte) {
                                                                                case (byte) -55:
                                                                                case (byte) -54:
                                                                                case (byte) -53:
                                                                                    break;
                                                                                default:
                                                                                    switch (readByte) {
                                                                                        case (byte) -51:
                                                                                        case (byte) -50:
                                                                                        case (byte) -49:
                                                                                            break;
                                                                                        default:
                                                                                            break;
                                                                                    }
                                                                            }
                                                                    }
                                                                    if (byteOrderedDataInputStream.skipBytes(1) == 1) {
                                                                        this.mAttributes[i2].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong((long) byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                                        this.mAttributes[i2].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong((long) byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                                        readUnsignedShort -= 5;
                                                                        break;
                                                                    }
                                                                    throw new IOException("Invalid SOFx");
                                                            }
                                                            if (readUnsignedShort >= 0) {
                                                                throw new IOException("Invalid length");
                                                            } else if (byteOrderedDataInputStream.skipBytes(readUnsignedShort) == readUnsignedShort) {
                                                                i += readUnsignedShort;
                                                            } else {
                                                                throw new IOException("Invalid JPEG segment");
                                                            }
                                                        } else {
                                                            bArr = new byte[readUnsignedShort];
                                                            if (byteOrderedDataInputStream.read(bArr) != readUnsignedShort) {
                                                                throw new IOException("Invalid exif");
                                                            } else if (getAttribute(TAG_USER_COMMENT) == null) {
                                                                this.mAttributes[1].put(TAG_USER_COMMENT, ExifAttribute.createString(new String(bArr, ASCII)));
                                                            }
                                                        }
                                                        readUnsignedShort = 0;
                                                        if (readUnsignedShort >= 0) {
                                                            throw new IOException("Invalid length");
                                                        } else if (byteOrderedDataInputStream.skipBytes(readUnsignedShort) == readUnsignedShort) {
                                                            i += readUnsignedShort;
                                                        } else {
                                                            throw new IOException("Invalid JPEG segment");
                                                        }
                                                    }
                                                    throw new IOException("Invalid length");
                                                }
                                            }
                                            byteOrderedDataInputStream.setByteOrder(this.mExifByteOrder);
                                            return;
                                        }
                                        i = new StringBuilder();
                                        i.append("Invalid marker:");
                                        i.append(Integer.toHexString(readByte & 255));
                                        throw new IOException(i.toString());
                                    }
                                }
                                i = new StringBuilder();
                                i.append("Invalid marker: ");
                                i.append(Integer.toHexString(readByte & 255));
                                throw new IOException(i.toString());
                            }
                            i = new StringBuilder();
                            i.append("Invalid marker: ");
                            i.append(Integer.toHexString(readByte & 255));
                            throw new IOException(i.toString());
                        }

                        private void getRawAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
                            parseTiffHeaders(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
                            readImageFileDirectory(byteOrderedDataInputStream, 0);
                            updateImageSizeValues(byteOrderedDataInputStream, 0);
                            updateImageSizeValues(byteOrderedDataInputStream, 5);
                            updateImageSizeValues(byteOrderedDataInputStream, 4);
                            validateImages(byteOrderedDataInputStream);
                            if (this.mMimeType == 8) {
                                ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes[1].get(TAG_MAKER_NOTE);
                                if (exifAttribute != null) {
                                    ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
                                    byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
                                    byteOrderedDataInputStream2.seek(6);
                                    readImageFileDirectory(byteOrderedDataInputStream2, 9);
                                    exifAttribute = (ExifAttribute) this.mAttributes[9].get(TAG_COLOR_SPACE);
                                    if (exifAttribute != null) {
                                        this.mAttributes[1].put(TAG_COLOR_SPACE, exifAttribute);
                                    }
                                }
                            }
                        }

                        private void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
                            byteOrderedDataInputStream.skipBytes(84);
                            byte[] bArr = new byte[4];
                            byte[] bArr2 = new byte[4];
                            byteOrderedDataInputStream.read(bArr);
                            byteOrderedDataInputStream.skipBytes(4);
                            byteOrderedDataInputStream.read(bArr2);
                            int i = ByteBuffer.wrap(bArr).getInt();
                            int i2 = ByteBuffer.wrap(bArr2).getInt();
                            getJpegAttributes(byteOrderedDataInputStream, i, 5);
                            byteOrderedDataInputStream.seek((long) i2);
                            byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
                            i = byteOrderedDataInputStream.readInt();
                            for (int i3 = 0; i3 < i; i3++) {
                                int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                                int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                                if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                                    i = byteOrderedDataInputStream.readShort();
                                    int readShort = byteOrderedDataInputStream.readShort();
                                    ExifAttribute createUShort = ExifAttribute.createUShort(i, this.mExifByteOrder);
                                    byteOrderedDataInputStream = ExifAttribute.createUShort(readShort, this.mExifByteOrder);
                                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort);
                                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, byteOrderedDataInputStream);
                                    return;
                                }
                                byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
                            }
                        }

                        private void getOrfAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
                            getRawAttributes(byteOrderedDataInputStream);
                            ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes[1].get(TAG_MAKER_NOTE);
                            if (exifAttribute != null) {
                                ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
                                byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
                                byteOrderedDataInputStream = new byte[ORF_MAKER_NOTE_HEADER_1.length];
                                byteOrderedDataInputStream2.readFully(byteOrderedDataInputStream);
                                byteOrderedDataInputStream2.seek(0);
                                byte[] bArr = new byte[ORF_MAKER_NOTE_HEADER_2.length];
                                byteOrderedDataInputStream2.readFully(bArr);
                                if (Arrays.equals(byteOrderedDataInputStream, ORF_MAKER_NOTE_HEADER_1) != null) {
                                    byteOrderedDataInputStream2.seek(8);
                                } else if (Arrays.equals(bArr, ORF_MAKER_NOTE_HEADER_2) != null) {
                                    byteOrderedDataInputStream2.seek(12);
                                }
                                readImageFileDirectory(byteOrderedDataInputStream2, 6);
                                exifAttribute = (ExifAttribute) this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
                                ExifAttribute exifAttribute2 = (ExifAttribute) this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
                                if (!(exifAttribute == null || exifAttribute2 == null)) {
                                    this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute);
                                    this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute2);
                                }
                                exifAttribute = (ExifAttribute) this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
                                if (exifAttribute != null) {
                                    int[] iArr = (int[]) exifAttribute.getValue(this.mExifByteOrder);
                                    if (iArr != null) {
                                        if (iArr.length == 4) {
                                            if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                                                int i = (iArr[2] - iArr[0]) + 1;
                                                int i2 = (iArr[3] - iArr[1]) + 1;
                                                if (i < i2) {
                                                    i += i2;
                                                    i2 = i - i2;
                                                    i -= i2;
                                                }
                                                byteOrderedDataInputStream = ExifAttribute.createUShort(i, this.mExifByteOrder);
                                                ExifAttribute createUShort = ExifAttribute.createUShort(i2, this.mExifByteOrder);
                                                this.mAttributes[0].put(TAG_IMAGE_WIDTH, byteOrderedDataInputStream);
                                                this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort);
                                            }
                                        }
                                    }
                                    String str = TAG;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Invalid aspect frame values. frame=");
                                    stringBuilder.append(Arrays.toString(iArr));
                                    Log.w(str, stringBuilder.toString());
                                }
                            }
                        }

                        private void getRw2Attributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
                            getRawAttributes(byteOrderedDataInputStream);
                            if (((ExifAttribute) this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW)) != null) {
                                getJpegAttributes(byteOrderedDataInputStream, this.mRw2JpgFromRawOffset, 5);
                            }
                            ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes[0].get(TAG_RW2_ISO);
                            ExifAttribute exifAttribute2 = (ExifAttribute) this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
                            if (exifAttribute != null && exifAttribute2 == null) {
                                this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute);
                            }
                        }

                        private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
                            InputStream dataInputStream = new DataInputStream(inputStream);
                            inputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
                            if (dataInputStream.readByte() == -1) {
                                inputStream.writeByte(-1);
                                if (dataInputStream.readByte() == -40) {
                                    inputStream.writeByte(-40);
                                    inputStream.writeByte(-1);
                                    inputStream.writeByte(-31);
                                    writeExifSegment(inputStream, 6);
                                    byte[] bArr = new byte[4096];
                                    while (dataInputStream.readByte() == MARKER) {
                                        byte readByte = dataInputStream.readByte();
                                        int readUnsignedShort;
                                        int read;
                                        if (readByte != MARKER_APP1) {
                                            switch (readByte) {
                                                case (byte) -39:
                                                case (byte) -38:
                                                    inputStream.writeByte(-1);
                                                    inputStream.writeByte(readByte);
                                                    copy(dataInputStream, inputStream);
                                                    return;
                                                default:
                                                    inputStream.writeByte(-1);
                                                    inputStream.writeByte(readByte);
                                                    readUnsignedShort = dataInputStream.readUnsignedShort();
                                                    inputStream.writeUnsignedShort(readUnsignedShort);
                                                    readUnsignedShort -= 2;
                                                    if (readUnsignedShort >= 0) {
                                                        while (readUnsignedShort > 0) {
                                                            read = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort, bArr.length));
                                                            if (read < 0) {
                                                                break;
                                                            }
                                                            inputStream.write(bArr, 0, read);
                                                            readUnsignedShort -= read;
                                                        }
                                                        break;
                                                    }
                                                    throw new IOException("Invalid length");
                                            }
                                        }
                                        read = dataInputStream.readUnsignedShort() - 2;
                                        if (read >= 0) {
                                            byte[] bArr2 = new byte[6];
                                            if (read >= 6) {
                                                if (dataInputStream.read(bArr2) != 6) {
                                                    throw new IOException("Invalid exif");
                                                } else if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                                                    read -= 6;
                                                    if (dataInputStream.skipBytes(read) != read) {
                                                        throw new IOException("Invalid length");
                                                    }
                                                }
                                            }
                                            inputStream.writeByte(-1);
                                            inputStream.writeByte(readByte);
                                            inputStream.writeUnsignedShort(read + 2);
                                            if (read >= 6) {
                                                read -= 6;
                                                inputStream.write(bArr2);
                                            }
                                            while (read > 0) {
                                                readUnsignedShort = dataInputStream.read(bArr, 0, Math.min(read, bArr.length));
                                                if (readUnsignedShort >= 0) {
                                                    inputStream.write(bArr, 0, readUnsignedShort);
                                                    read -= readUnsignedShort;
                                                }
                                            }
                                        } else {
                                            throw new IOException("Invalid length");
                                        }
                                    }
                                    throw new IOException("Invalid marker");
                                }
                                throw new IOException("Invalid marker");
                            }
                            throw new IOException("Invalid marker");
                        }

                        private void readExifSegment(byte[] bArr, int i) throws IOException {
                            ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
                            parseTiffHeaders(byteOrderedDataInputStream, bArr.length);
                            readImageFileDirectory(byteOrderedDataInputStream, i);
                        }

                        private void addDefaultValuesForCompatibility() {
                            String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
                            if (attribute != null && getAttribute(TAG_DATETIME) == null) {
                                this.mAttributes[0].put(TAG_DATETIME, ExifAttribute.createString(attribute));
                            }
                            if (getAttribute(TAG_IMAGE_WIDTH) == null) {
                                this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(0, this.mExifByteOrder));
                            }
                            if (getAttribute(TAG_IMAGE_LENGTH) == null) {
                                this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(0, this.mExifByteOrder));
                            }
                            if (getAttribute(TAG_ORIENTATION) == null) {
                                this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createULong(0, this.mExifByteOrder));
                            }
                            if (getAttribute(TAG_LIGHT_SOURCE) == null) {
                                this.mAttributes[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0, this.mExifByteOrder));
                            }
                        }

                        private ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
                            byteOrderedDataInputStream = byteOrderedDataInputStream.readShort();
                            if (byteOrderedDataInputStream == 18761) {
                                return ByteOrder.LITTLE_ENDIAN;
                            }
                            if (byteOrderedDataInputStream == 19789) {
                                return ByteOrder.BIG_ENDIAN;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid byte order: ");
                            stringBuilder.append(Integer.toHexString(byteOrderedDataInputStream));
                            throw new IOException(stringBuilder.toString());
                        }

                        private void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
                            this.mExifByteOrder = readByteOrder(byteOrderedDataInputStream);
                            byteOrderedDataInputStream.setByteOrder(this.mExifByteOrder);
                            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                            if (!(this.mMimeType == 7 || this.mMimeType == 10)) {
                                if (readUnsignedShort != 42) {
                                    i = new StringBuilder();
                                    i.append("Invalid start code: ");
                                    i.append(Integer.toHexString(readUnsignedShort));
                                    throw new IOException(i.toString());
                                }
                            }
                            readUnsignedShort = byteOrderedDataInputStream.readInt();
                            if (readUnsignedShort < 8 || readUnsignedShort >= i) {
                                i = new StringBuilder();
                                i.append("Invalid first Ifd offset: ");
                                i.append(readUnsignedShort);
                                throw new IOException(i.toString());
                            }
                            readUnsignedShort -= 8;
                            if (readUnsignedShort <= 0) {
                                return;
                            }
                            if (byteOrderedDataInputStream.skipBytes(readUnsignedShort) != readUnsignedShort) {
                                i = new StringBuilder();
                                i.append("Couldn't jump to first Ifd: ");
                                i.append(readUnsignedShort);
                                throw new IOException(i.toString());
                            }
                        }

                        private void readImageFileDirectory(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
                            ExifInterface exifInterface = this;
                            ByteOrderedDataInputStream byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                            int i2 = i;
                            if (byteOrderedDataInputStream.mPosition + 2 <= byteOrderedDataInputStream.mLength) {
                                short readShort = byteOrderedDataInputStream.readShort();
                                if (byteOrderedDataInputStream.mPosition + (12 * readShort) <= byteOrderedDataInputStream.mLength) {
                                    short s = (short) 0;
                                    while (s < readShort) {
                                        long j;
                                        Object obj;
                                        int i3;
                                        short s2;
                                        int readInt;
                                        ExifAttribute createUShort;
                                        ExifAttribute createULong;
                                        ExifAttribute createULong2;
                                        long j2;
                                        int i4;
                                        ExifTag exifTag;
                                        Integer num;
                                        String str;
                                        StringBuilder stringBuilder;
                                        byte[] bArr;
                                        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                                        int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                                        int readInt2 = byteOrderedDataInputStream.readInt();
                                        short s3 = s;
                                        long peek = ((long) byteOrderedDataInputStream.peek()) + 4;
                                        ExifTag exifTag2 = (ExifTag) sExifTagMapsForReading[i2].get(Integer.valueOf(readUnsignedShort));
                                        if (exifTag2 == null) {
                                            String str2 = TAG;
                                            StringBuilder stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append("Skip the tag entry since tag number is not defined: ");
                                            stringBuilder2.append(readUnsignedShort);
                                            Log.w(str2, stringBuilder2.toString());
                                        } else {
                                            String str3;
                                            StringBuilder stringBuilder3;
                                            if (readUnsignedShort2 > 0) {
                                                if (readUnsignedShort2 < IFD_FORMAT_BYTES_PER_FORMAT.length) {
                                                    if (exifTag2.isFormatCompatible(readUnsignedShort2)) {
                                                        if (readUnsignedShort2 == 7) {
                                                            readUnsignedShort2 = exifTag2.primaryFormat;
                                                        }
                                                        j = ((long) readInt2) * ((long) IFD_FORMAT_BYTES_PER_FORMAT[readUnsignedShort2]);
                                                        if (j >= 0) {
                                                            if (j <= 2147483647L) {
                                                                obj = 1;
                                                                if (obj == null) {
                                                                    byteOrderedDataInputStream2.seek(peek);
                                                                    i3 = i2;
                                                                    s2 = readShort;
                                                                } else {
                                                                    if (j > 4) {
                                                                        readInt = byteOrderedDataInputStream.readInt();
                                                                        if (exifInterface.mMimeType == 7) {
                                                                            if (TAG_MAKER_NOTE.equals(exifTag2.name)) {
                                                                                exifInterface.mOrfMakerNoteOffset = readInt;
                                                                            } else if (i2 == 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(exifTag2.name)) {
                                                                                exifInterface.mOrfThumbnailOffset = readInt;
                                                                                exifInterface.mOrfThumbnailLength = readInt2;
                                                                                createUShort = ExifAttribute.createUShort(6, exifInterface.mExifByteOrder);
                                                                                s2 = readShort;
                                                                                createULong = ExifAttribute.createULong((long) exifInterface.mOrfThumbnailOffset, exifInterface.mExifByteOrder);
                                                                                createULong2 = ExifAttribute.createULong((long) exifInterface.mOrfThumbnailLength, exifInterface.mExifByteOrder);
                                                                                exifInterface.mAttributes[4].put(TAG_COMPRESSION, createUShort);
                                                                                exifInterface.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, createULong);
                                                                                exifInterface.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, createULong2);
                                                                            }
                                                                            s2 = readShort;
                                                                        } else {
                                                                            s2 = readShort;
                                                                            if (exifInterface.mMimeType == 10 && TAG_RW2_JPG_FROM_RAW.equals(exifTag2.name)) {
                                                                                exifInterface.mRw2JpgFromRawOffset = readInt;
                                                                            }
                                                                        }
                                                                        j2 = (long) readInt;
                                                                        i4 = readInt2;
                                                                        exifTag = exifTag2;
                                                                        if (j2 + j <= ((long) byteOrderedDataInputStream.mLength)) {
                                                                            byteOrderedDataInputStream2.seek(j2);
                                                                            num = (Integer) sExifPointerTagMap.get(Integer.valueOf(readUnsignedShort));
                                                                            if (num == null) {
                                                                                j = -1;
                                                                                switch (readUnsignedShort2) {
                                                                                    case 3:
                                                                                        j = (long) byteOrderedDataInputStream.readUnsignedShort();
                                                                                        break;
                                                                                    case 4:
                                                                                        j = byteOrderedDataInputStream.readUnsignedInt();
                                                                                        break;
                                                                                    case 8:
                                                                                        j = (long) byteOrderedDataInputStream.readShort();
                                                                                        break;
                                                                                    case 9:
                                                                                    case 13:
                                                                                        j = (long) byteOrderedDataInputStream.readInt();
                                                                                        break;
                                                                                    default:
                                                                                        break;
                                                                                }
                                                                                if (j > 0 || j >= ((long) byteOrderedDataInputStream.mLength)) {
                                                                                    str = TAG;
                                                                                    stringBuilder = new StringBuilder();
                                                                                    stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                                                    stringBuilder.append(j);
                                                                                    Log.w(str, stringBuilder.toString());
                                                                                } else {
                                                                                    byteOrderedDataInputStream2.seek(j);
                                                                                    readImageFileDirectory(byteOrderedDataInputStream2, num.intValue());
                                                                                }
                                                                                byteOrderedDataInputStream2.seek(peek);
                                                                            } else {
                                                                                bArr = new byte[((int) j)];
                                                                                byteOrderedDataInputStream2.readFully(bArr);
                                                                                createULong = new ExifAttribute(readUnsignedShort2, i4, bArr);
                                                                                i3 = i;
                                                                                exifTag2 = exifTag;
                                                                                exifInterface.mAttributes[i3].put(exifTag2.name, createULong);
                                                                                if (TAG_DNG_VERSION.equals(exifTag2.name)) {
                                                                                    exifInterface.mMimeType = 3;
                                                                                }
                                                                                if (((TAG_MAKE.equals(exifTag2.name) || TAG_MODEL.equals(exifTag2.name)) && createULong.getStringValue(exifInterface.mExifByteOrder).contains(PEF_SIGNATURE)) || (TAG_COMPRESSION.equals(exifTag2.name) && createULong.getIntValue(exifInterface.mExifByteOrder) == 65535)) {
                                                                                    exifInterface.mMimeType = 8;
                                                                                }
                                                                                if (((long) byteOrderedDataInputStream.peek()) != peek) {
                                                                                    byteOrderedDataInputStream2.seek(peek);
                                                                                }
                                                                            }
                                                                        } else {
                                                                            str = TAG;
                                                                            stringBuilder = new StringBuilder();
                                                                            stringBuilder.append("Skip the tag entry since data offset is invalid: ");
                                                                            stringBuilder.append(readInt);
                                                                            Log.w(str, stringBuilder.toString());
                                                                            byteOrderedDataInputStream2.seek(peek);
                                                                        }
                                                                    } else {
                                                                        s2 = readShort;
                                                                        i4 = readInt2;
                                                                        exifTag = exifTag2;
                                                                        num = (Integer) sExifPointerTagMap.get(Integer.valueOf(readUnsignedShort));
                                                                        if (num == null) {
                                                                            bArr = new byte[((int) j)];
                                                                            byteOrderedDataInputStream2.readFully(bArr);
                                                                            createULong = new ExifAttribute(readUnsignedShort2, i4, bArr);
                                                                            i3 = i;
                                                                            exifTag2 = exifTag;
                                                                            exifInterface.mAttributes[i3].put(exifTag2.name, createULong);
                                                                            if (TAG_DNG_VERSION.equals(exifTag2.name)) {
                                                                                exifInterface.mMimeType = 3;
                                                                            }
                                                                            exifInterface.mMimeType = 8;
                                                                            if (((long) byteOrderedDataInputStream.peek()) != peek) {
                                                                                byteOrderedDataInputStream2.seek(peek);
                                                                            }
                                                                        } else {
                                                                            j = -1;
                                                                            switch (readUnsignedShort2) {
                                                                                case 3:
                                                                                    j = (long) byteOrderedDataInputStream.readUnsignedShort();
                                                                                    break;
                                                                                case 4:
                                                                                    j = byteOrderedDataInputStream.readUnsignedInt();
                                                                                    break;
                                                                                case 8:
                                                                                    j = (long) byteOrderedDataInputStream.readShort();
                                                                                    break;
                                                                                case 9:
                                                                                case 13:
                                                                                    j = (long) byteOrderedDataInputStream.readInt();
                                                                                    break;
                                                                                default:
                                                                                    break;
                                                                            }
                                                                            if (j > 0) {
                                                                            }
                                                                            str = TAG;
                                                                            stringBuilder = new StringBuilder();
                                                                            stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                                            stringBuilder.append(j);
                                                                            Log.w(str, stringBuilder.toString());
                                                                            byteOrderedDataInputStream2.seek(peek);
                                                                        }
                                                                    }
                                                                    i3 = i;
                                                                }
                                                                s = (short) (s3 + 1);
                                                                i2 = i3;
                                                                readShort = s2;
                                                            }
                                                        }
                                                        String str4 = TAG;
                                                        StringBuilder stringBuilder4 = new StringBuilder();
                                                        stringBuilder4.append("Skip the tag entry since the number of components is invalid: ");
                                                        stringBuilder4.append(readInt2);
                                                        Log.w(str4, stringBuilder4.toString());
                                                        obj = null;
                                                        if (obj == null) {
                                                            if (j > 4) {
                                                                s2 = readShort;
                                                                i4 = readInt2;
                                                                exifTag = exifTag2;
                                                                num = (Integer) sExifPointerTagMap.get(Integer.valueOf(readUnsignedShort));
                                                                if (num == null) {
                                                                    j = -1;
                                                                    switch (readUnsignedShort2) {
                                                                        case 3:
                                                                            j = (long) byteOrderedDataInputStream.readUnsignedShort();
                                                                            break;
                                                                        case 4:
                                                                            j = byteOrderedDataInputStream.readUnsignedInt();
                                                                            break;
                                                                        case 8:
                                                                            j = (long) byteOrderedDataInputStream.readShort();
                                                                            break;
                                                                        case 9:
                                                                        case 13:
                                                                            j = (long) byteOrderedDataInputStream.readInt();
                                                                            break;
                                                                        default:
                                                                            break;
                                                                    }
                                                                    if (j > 0) {
                                                                    }
                                                                    str = TAG;
                                                                    stringBuilder = new StringBuilder();
                                                                    stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                                    stringBuilder.append(j);
                                                                    Log.w(str, stringBuilder.toString());
                                                                    byteOrderedDataInputStream2.seek(peek);
                                                                } else {
                                                                    bArr = new byte[((int) j)];
                                                                    byteOrderedDataInputStream2.readFully(bArr);
                                                                    createULong = new ExifAttribute(readUnsignedShort2, i4, bArr);
                                                                    i3 = i;
                                                                    exifTag2 = exifTag;
                                                                    exifInterface.mAttributes[i3].put(exifTag2.name, createULong);
                                                                    if (TAG_DNG_VERSION.equals(exifTag2.name)) {
                                                                        exifInterface.mMimeType = 3;
                                                                    }
                                                                    exifInterface.mMimeType = 8;
                                                                    if (((long) byteOrderedDataInputStream.peek()) != peek) {
                                                                        byteOrderedDataInputStream2.seek(peek);
                                                                    }
                                                                }
                                                            } else {
                                                                readInt = byteOrderedDataInputStream.readInt();
                                                                if (exifInterface.mMimeType == 7) {
                                                                    s2 = readShort;
                                                                    exifInterface.mRw2JpgFromRawOffset = readInt;
                                                                } else {
                                                                    if (TAG_MAKER_NOTE.equals(exifTag2.name)) {
                                                                        exifInterface.mOrfThumbnailOffset = readInt;
                                                                        exifInterface.mOrfThumbnailLength = readInt2;
                                                                        createUShort = ExifAttribute.createUShort(6, exifInterface.mExifByteOrder);
                                                                        s2 = readShort;
                                                                        createULong = ExifAttribute.createULong((long) exifInterface.mOrfThumbnailOffset, exifInterface.mExifByteOrder);
                                                                        createULong2 = ExifAttribute.createULong((long) exifInterface.mOrfThumbnailLength, exifInterface.mExifByteOrder);
                                                                        exifInterface.mAttributes[4].put(TAG_COMPRESSION, createUShort);
                                                                        exifInterface.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, createULong);
                                                                        exifInterface.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, createULong2);
                                                                    } else {
                                                                        exifInterface.mOrfMakerNoteOffset = readInt;
                                                                    }
                                                                    s2 = readShort;
                                                                }
                                                                j2 = (long) readInt;
                                                                i4 = readInt2;
                                                                exifTag = exifTag2;
                                                                if (j2 + j <= ((long) byteOrderedDataInputStream.mLength)) {
                                                                    str = TAG;
                                                                    stringBuilder = new StringBuilder();
                                                                    stringBuilder.append("Skip the tag entry since data offset is invalid: ");
                                                                    stringBuilder.append(readInt);
                                                                    Log.w(str, stringBuilder.toString());
                                                                    byteOrderedDataInputStream2.seek(peek);
                                                                } else {
                                                                    byteOrderedDataInputStream2.seek(j2);
                                                                    num = (Integer) sExifPointerTagMap.get(Integer.valueOf(readUnsignedShort));
                                                                    if (num == null) {
                                                                        bArr = new byte[((int) j)];
                                                                        byteOrderedDataInputStream2.readFully(bArr);
                                                                        createULong = new ExifAttribute(readUnsignedShort2, i4, bArr);
                                                                        i3 = i;
                                                                        exifTag2 = exifTag;
                                                                        exifInterface.mAttributes[i3].put(exifTag2.name, createULong);
                                                                        if (TAG_DNG_VERSION.equals(exifTag2.name)) {
                                                                            exifInterface.mMimeType = 3;
                                                                        }
                                                                        exifInterface.mMimeType = 8;
                                                                        if (((long) byteOrderedDataInputStream.peek()) != peek) {
                                                                            byteOrderedDataInputStream2.seek(peek);
                                                                        }
                                                                    } else {
                                                                        j = -1;
                                                                        switch (readUnsignedShort2) {
                                                                            case 3:
                                                                                j = (long) byteOrderedDataInputStream.readUnsignedShort();
                                                                                break;
                                                                            case 4:
                                                                                j = byteOrderedDataInputStream.readUnsignedInt();
                                                                                break;
                                                                            case 8:
                                                                                j = (long) byteOrderedDataInputStream.readShort();
                                                                                break;
                                                                            case 9:
                                                                            case 13:
                                                                                j = (long) byteOrderedDataInputStream.readInt();
                                                                                break;
                                                                            default:
                                                                                break;
                                                                        }
                                                                        if (j > 0) {
                                                                        }
                                                                        str = TAG;
                                                                        stringBuilder = new StringBuilder();
                                                                        stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                                        stringBuilder.append(j);
                                                                        Log.w(str, stringBuilder.toString());
                                                                        byteOrderedDataInputStream2.seek(peek);
                                                                    }
                                                                }
                                                            }
                                                            i3 = i;
                                                        } else {
                                                            byteOrderedDataInputStream2.seek(peek);
                                                            i3 = i2;
                                                            s2 = readShort;
                                                        }
                                                        s = (short) (s3 + 1);
                                                        i2 = i3;
                                                        readShort = s2;
                                                    } else {
                                                        str3 = TAG;
                                                        stringBuilder3 = new StringBuilder();
                                                        stringBuilder3.append("Skip the tag entry since data format (");
                                                        stringBuilder3.append(IFD_FORMAT_NAMES[readUnsignedShort2]);
                                                        stringBuilder3.append(") is unexpected for tag: ");
                                                        stringBuilder3.append(exifTag2.name);
                                                        Log.w(str3, stringBuilder3.toString());
                                                    }
                                                }
                                            }
                                            str3 = TAG;
                                            stringBuilder3 = new StringBuilder();
                                            stringBuilder3.append("Skip the tag entry since data format is invalid: ");
                                            stringBuilder3.append(readUnsignedShort2);
                                            Log.w(str3, stringBuilder3.toString());
                                        }
                                        j = 0;
                                        obj = null;
                                        if (obj == null) {
                                            byteOrderedDataInputStream2.seek(peek);
                                            i3 = i2;
                                            s2 = readShort;
                                        } else {
                                            if (j > 4) {
                                                readInt = byteOrderedDataInputStream.readInt();
                                                if (exifInterface.mMimeType == 7) {
                                                    if (TAG_MAKER_NOTE.equals(exifTag2.name)) {
                                                        exifInterface.mOrfMakerNoteOffset = readInt;
                                                    } else {
                                                        exifInterface.mOrfThumbnailOffset = readInt;
                                                        exifInterface.mOrfThumbnailLength = readInt2;
                                                        createUShort = ExifAttribute.createUShort(6, exifInterface.mExifByteOrder);
                                                        s2 = readShort;
                                                        createULong = ExifAttribute.createULong((long) exifInterface.mOrfThumbnailOffset, exifInterface.mExifByteOrder);
                                                        createULong2 = ExifAttribute.createULong((long) exifInterface.mOrfThumbnailLength, exifInterface.mExifByteOrder);
                                                        exifInterface.mAttributes[4].put(TAG_COMPRESSION, createUShort);
                                                        exifInterface.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, createULong);
                                                        exifInterface.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, createULong2);
                                                    }
                                                    s2 = readShort;
                                                } else {
                                                    s2 = readShort;
                                                    exifInterface.mRw2JpgFromRawOffset = readInt;
                                                }
                                                j2 = (long) readInt;
                                                i4 = readInt2;
                                                exifTag = exifTag2;
                                                if (j2 + j <= ((long) byteOrderedDataInputStream.mLength)) {
                                                    byteOrderedDataInputStream2.seek(j2);
                                                    num = (Integer) sExifPointerTagMap.get(Integer.valueOf(readUnsignedShort));
                                                    if (num == null) {
                                                        j = -1;
                                                        switch (readUnsignedShort2) {
                                                            case 3:
                                                                j = (long) byteOrderedDataInputStream.readUnsignedShort();
                                                                break;
                                                            case 4:
                                                                j = byteOrderedDataInputStream.readUnsignedInt();
                                                                break;
                                                            case 8:
                                                                j = (long) byteOrderedDataInputStream.readShort();
                                                                break;
                                                            case 9:
                                                            case 13:
                                                                j = (long) byteOrderedDataInputStream.readInt();
                                                                break;
                                                            default:
                                                                break;
                                                        }
                                                        if (j > 0) {
                                                        }
                                                        str = TAG;
                                                        stringBuilder = new StringBuilder();
                                                        stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                        stringBuilder.append(j);
                                                        Log.w(str, stringBuilder.toString());
                                                        byteOrderedDataInputStream2.seek(peek);
                                                    } else {
                                                        bArr = new byte[((int) j)];
                                                        byteOrderedDataInputStream2.readFully(bArr);
                                                        createULong = new ExifAttribute(readUnsignedShort2, i4, bArr);
                                                        i3 = i;
                                                        exifTag2 = exifTag;
                                                        exifInterface.mAttributes[i3].put(exifTag2.name, createULong);
                                                        if (TAG_DNG_VERSION.equals(exifTag2.name)) {
                                                            exifInterface.mMimeType = 3;
                                                        }
                                                        exifInterface.mMimeType = 8;
                                                        if (((long) byteOrderedDataInputStream.peek()) != peek) {
                                                            byteOrderedDataInputStream2.seek(peek);
                                                        }
                                                    }
                                                } else {
                                                    str = TAG;
                                                    stringBuilder = new StringBuilder();
                                                    stringBuilder.append("Skip the tag entry since data offset is invalid: ");
                                                    stringBuilder.append(readInt);
                                                    Log.w(str, stringBuilder.toString());
                                                    byteOrderedDataInputStream2.seek(peek);
                                                }
                                            } else {
                                                s2 = readShort;
                                                i4 = readInt2;
                                                exifTag = exifTag2;
                                                num = (Integer) sExifPointerTagMap.get(Integer.valueOf(readUnsignedShort));
                                                if (num == null) {
                                                    bArr = new byte[((int) j)];
                                                    byteOrderedDataInputStream2.readFully(bArr);
                                                    createULong = new ExifAttribute(readUnsignedShort2, i4, bArr);
                                                    i3 = i;
                                                    exifTag2 = exifTag;
                                                    exifInterface.mAttributes[i3].put(exifTag2.name, createULong);
                                                    if (TAG_DNG_VERSION.equals(exifTag2.name)) {
                                                        exifInterface.mMimeType = 3;
                                                    }
                                                    exifInterface.mMimeType = 8;
                                                    if (((long) byteOrderedDataInputStream.peek()) != peek) {
                                                        byteOrderedDataInputStream2.seek(peek);
                                                    }
                                                } else {
                                                    j = -1;
                                                    switch (readUnsignedShort2) {
                                                        case 3:
                                                            j = (long) byteOrderedDataInputStream.readUnsignedShort();
                                                            break;
                                                        case 4:
                                                            j = byteOrderedDataInputStream.readUnsignedInt();
                                                            break;
                                                        case 8:
                                                            j = (long) byteOrderedDataInputStream.readShort();
                                                            break;
                                                        case 9:
                                                        case 13:
                                                            j = (long) byteOrderedDataInputStream.readInt();
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                    if (j > 0) {
                                                    }
                                                    str = TAG;
                                                    stringBuilder = new StringBuilder();
                                                    stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                    stringBuilder.append(j);
                                                    Log.w(str, stringBuilder.toString());
                                                    byteOrderedDataInputStream2.seek(peek);
                                                }
                                            }
                                            i3 = i;
                                        }
                                        s = (short) (s3 + 1);
                                        i2 = i3;
                                        readShort = s2;
                                    }
                                    if (byteOrderedDataInputStream.peek() + 4 <= byteOrderedDataInputStream.mLength) {
                                        i2 = byteOrderedDataInputStream.readInt();
                                        if (i2 > 8 && i2 < byteOrderedDataInputStream.mLength) {
                                            byteOrderedDataInputStream2.seek((long) i2);
                                            if (exifInterface.mAttributes[4].isEmpty()) {
                                                readImageFileDirectory(byteOrderedDataInputStream2, 4);
                                            } else if (exifInterface.mAttributes[5].isEmpty()) {
                                                readImageFileDirectory(byteOrderedDataInputStream2, 5);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        private void retrieveJpegImageSize(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
                            ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes[i].get(TAG_IMAGE_WIDTH);
                            if (((ExifAttribute) this.mAttributes[i].get(TAG_IMAGE_LENGTH)) == null || exifAttribute == null) {
                                ExifAttribute exifAttribute2 = (ExifAttribute) this.mAttributes[i].get(TAG_JPEG_INTERCHANGE_FORMAT);
                                if (exifAttribute2 != null) {
                                    getJpegAttributes(byteOrderedDataInputStream, exifAttribute2.getIntValue(this.mExifByteOrder), i);
                                }
                            }
                        }

                        private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
                            HashMap hashMap = this.mAttributes[4];
                            ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_COMPRESSION);
                            if (exifAttribute != null) {
                                this.mThumbnailCompression = exifAttribute.getIntValue(this.mExifByteOrder);
                                int i = this.mThumbnailCompression;
                                if (i != 1) {
                                    switch (i) {
                                        case 6:
                                            handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                                            return;
                                        case 7:
                                            break;
                                        default:
                                            return;
                                    }
                                }
                                if (isSupportedDataType(hashMap)) {
                                    handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
                                    return;
                                }
                                return;
                            }
                            this.mThumbnailCompression = 6;
                            handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                        }

                        private void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
                            ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
                            ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
                            if (exifAttribute != null && exifAttribute2 != null) {
                                int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                                hashMap = Math.min(exifAttribute2.getIntValue(this.mExifByteOrder), byteOrderedDataInputStream.available() - intValue);
                                if (!(this.mMimeType == 4 || this.mMimeType == 9)) {
                                    if (this.mMimeType != 10) {
                                        if (this.mMimeType == 7) {
                                            intValue += this.mOrfMakerNoteOffset;
                                        }
                                        if (intValue > 0 && hashMap > null) {
                                            this.mHasThumbnail = true;
                                            this.mThumbnailOffset = intValue;
                                            this.mThumbnailLength = hashMap;
                                            if (this.mFilename == null && this.mAssetInputStream == null) {
                                                hashMap = new byte[hashMap];
                                                byteOrderedDataInputStream.seek((long) intValue);
                                                byteOrderedDataInputStream.readFully(hashMap);
                                                this.mThumbnailBytes = hashMap;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                intValue += this.mExifOffset;
                                if (intValue > 0) {
                                }
                            }
                        }

                        private void handleThumbnailFromStrips(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
                            ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_STRIP_OFFSETS);
                            ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_STRIP_BYTE_COUNTS);
                            if (!(exifAttribute == null || exifAttribute2 == null)) {
                                long[] convertToLongArray = convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
                                hashMap = convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
                                if (convertToLongArray == null) {
                                    Log.w(TAG, "stripOffsets should not be null.");
                                } else if (hashMap == null) {
                                    Log.w(TAG, "stripByteCounts should not be null.");
                                } else {
                                    long j = 0;
                                    int i = 0;
                                    while (i < hashMap.length) {
                                        i++;
                                        j += hashMap[i];
                                    }
                                    Object obj = new byte[((int) j)];
                                    int i2 = 0;
                                    int i3 = i2;
                                    int i4 = i3;
                                    while (i2 < convertToLongArray.length) {
                                        int i5 = (int) hashMap[i2];
                                        int i6 = ((int) convertToLongArray[i2]) - i3;
                                        if (i6 < 0) {
                                            Log.d(TAG, "Invalid strip offset value");
                                        }
                                        byteOrderedDataInputStream.seek((long) i6);
                                        i3 += i6;
                                        Object obj2 = new byte[i5];
                                        byteOrderedDataInputStream.read(obj2);
                                        i3 += i5;
                                        System.arraycopy(obj2, 0, obj, i4, obj2.length);
                                        i4 += obj2.length;
                                        i2++;
                                    }
                                    this.mHasThumbnail = true;
                                    this.mThumbnailBytes = obj;
                                    this.mThumbnailLength = obj.length;
                                }
                            }
                        }

                        private boolean isSupportedDataType(HashMap hashMap) throws IOException {
                            ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_BITS_PER_SAMPLE);
                            if (exifAttribute != null) {
                                int[] iArr = (int[]) exifAttribute.getValue(this.mExifByteOrder);
                                if (Arrays.equals(BITS_PER_SAMPLE_RGB, iArr)) {
                                    return true;
                                }
                                if (this.mMimeType == 3) {
                                    ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION);
                                    if (exifAttribute2 != null) {
                                        hashMap = exifAttribute2.getIntValue(this.mExifByteOrder);
                                        if ((hashMap == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (hashMap == 6 && Arrays.equals(iArr, BITS_PER_SAMPLE_RGB) != null)) {
                                            return true;
                                        }
                                    }
                                }
                            }
                            return null;
                        }

                        private boolean isThumbnail(HashMap hashMap) throws IOException {
                            ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_IMAGE_LENGTH);
                            ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_IMAGE_WIDTH);
                            if (!(exifAttribute == null || exifAttribute2 == null)) {
                                int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                                hashMap = exifAttribute2.getIntValue(this.mExifByteOrder);
                                if (intValue <= 512 && hashMap <= 512) {
                                    return true;
                                }
                            }
                            return null;
                        }

                        private void validateImages(InputStream inputStream) throws IOException {
                            swapBasedOnImageSize(0, 5);
                            swapBasedOnImageSize(0, 4);
                            swapBasedOnImageSize(5, 4);
                            ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
                            ExifAttribute exifAttribute2 = (ExifAttribute) this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
                            if (!(exifAttribute == null || exifAttribute2 == null)) {
                                this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifAttribute);
                                this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifAttribute2);
                            }
                            if (!(this.mAttributes[4].isEmpty() == null || isThumbnail(this.mAttributes[5]) == null)) {
                                this.mAttributes[4] = this.mAttributes[5];
                                this.mAttributes[5] = new HashMap();
                            }
                            if (isThumbnail(this.mAttributes[4]) == null) {
                                Log.d(TAG, "No image meets the size requirements of a thumbnail image.");
                            }
                        }

                        private void updateImageSizeValues(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
                            ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes[i].get(TAG_DEFAULT_CROP_SIZE);
                            ExifAttribute exifAttribute2 = (ExifAttribute) this.mAttributes[i].get(TAG_RW2_SENSOR_TOP_BORDER);
                            ExifAttribute exifAttribute3 = (ExifAttribute) this.mAttributes[i].get(TAG_RW2_SENSOR_LEFT_BORDER);
                            ExifAttribute exifAttribute4 = (ExifAttribute) this.mAttributes[i].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
                            ExifAttribute exifAttribute5 = (ExifAttribute) this.mAttributes[i].get(TAG_RW2_SENSOR_RIGHT_BORDER);
                            if (exifAttribute != null) {
                                Object createURational;
                                StringBuilder stringBuilder;
                                if (exifAttribute.format == 5) {
                                    Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                                    if (rationalArr != null) {
                                        if (rationalArr.length == 2) {
                                            createURational = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
                                            byteOrderedDataInputStream = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
                                        }
                                    }
                                    i = TAG;
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Invalid crop size values. cropSize=");
                                    stringBuilder.append(Arrays.toString(rationalArr));
                                    Log.w(i, stringBuilder.toString());
                                    return;
                                }
                                int[] iArr = (int[]) exifAttribute.getValue(this.mExifByteOrder);
                                if (iArr != null) {
                                    if (iArr.length == 2) {
                                        createURational = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                                        byteOrderedDataInputStream = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
                                    }
                                }
                                i = TAG;
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Invalid crop size values. cropSize=");
                                stringBuilder.append(Arrays.toString(iArr));
                                Log.w(i, stringBuilder.toString());
                                return;
                                this.mAttributes[i].put(TAG_IMAGE_WIDTH, createURational);
                                this.mAttributes[i].put(TAG_IMAGE_LENGTH, byteOrderedDataInputStream);
                            } else if (exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null || exifAttribute5 == null) {
                                retrieveJpegImageSize(byteOrderedDataInputStream, i);
                            } else {
                                byteOrderedDataInputStream = exifAttribute2.getIntValue(this.mExifByteOrder);
                                int intValue = exifAttribute4.getIntValue(this.mExifByteOrder);
                                int intValue2 = exifAttribute5.getIntValue(this.mExifByteOrder);
                                int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
                                if (intValue > byteOrderedDataInputStream && intValue2 > intValue3) {
                                    intValue2 -= intValue3;
                                    byteOrderedDataInputStream = ExifAttribute.createUShort(intValue - byteOrderedDataInputStream, this.mExifByteOrder);
                                    exifAttribute = ExifAttribute.createUShort(intValue2, this.mExifByteOrder);
                                    this.mAttributes[i].put(TAG_IMAGE_LENGTH, byteOrderedDataInputStream);
                                    this.mAttributes[i].put(TAG_IMAGE_WIDTH, exifAttribute);
                                }
                            }
                        }

                        private int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream, int i) throws IOException {
                            int i2;
                            int i3;
                            ExifInterface exifInterface = this;
                            ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = byteOrderedDataOutputStream;
                            int[] iArr = new int[EXIF_TAGS.length];
                            int[] iArr2 = new int[EXIF_TAGS.length];
                            for (ExifTag exifTag : EXIF_POINTER_TAGS) {
                                removeAttribute(exifTag.name);
                            }
                            removeAttribute(JPEG_INTERCHANGE_FORMAT_TAG.name);
                            removeAttribute(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
                            for (i2 = 0; i2 < EXIF_TAGS.length; i2++) {
                                int i4;
                                for (Object obj : exifInterface.mAttributes[i2].entrySet().toArray()) {
                                    Entry entry = (Entry) obj;
                                    if (entry.getValue() == null) {
                                        exifInterface.mAttributes[i2].remove(entry.getKey());
                                    }
                                }
                            }
                            if (!exifInterface.mAttributes[1].isEmpty()) {
                                exifInterface.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, exifInterface.mExifByteOrder));
                            }
                            if (!exifInterface.mAttributes[2].isEmpty()) {
                                exifInterface.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, exifInterface.mExifByteOrder));
                            }
                            if (!exifInterface.mAttributes[3].isEmpty()) {
                                exifInterface.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, exifInterface.mExifByteOrder));
                            }
                            if (exifInterface.mHasThumbnail) {
                                exifInterface.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(0, exifInterface.mExifByteOrder));
                                exifInterface.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, ExifAttribute.createULong((long) exifInterface.mThumbnailLength, exifInterface.mExifByteOrder));
                            }
                            for (i2 = 0; i2 < EXIF_TAGS.length; i2++) {
                                i3 = 0;
                                for (Entry value : exifInterface.mAttributes[i2].entrySet()) {
                                    int size = ((ExifAttribute) value.getValue()).size();
                                    if (size > 4) {
                                        i3 += size;
                                    }
                                }
                                iArr2[i2] = iArr2[i2] + i3;
                            }
                            i3 = 8;
                            for (int i5 = 0; i5 < EXIF_TAGS.length; i5++) {
                                if (!exifInterface.mAttributes[i5].isEmpty()) {
                                    iArr[i5] = i3;
                                    i3 += (((exifInterface.mAttributes[i5].size() * 12) + 2) + 4) + iArr2[i5];
                                }
                            }
                            if (exifInterface.mHasThumbnail) {
                                exifInterface.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong((long) i3, exifInterface.mExifByteOrder));
                                exifInterface.mThumbnailOffset = i + i3;
                                i3 += exifInterface.mThumbnailLength;
                            }
                            i3 += 8;
                            if (!exifInterface.mAttributes[1].isEmpty()) {
                                exifInterface.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong((long) iArr[1], exifInterface.mExifByteOrder));
                            }
                            if (!exifInterface.mAttributes[2].isEmpty()) {
                                exifInterface.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong((long) iArr[2], exifInterface.mExifByteOrder));
                            }
                            if (!exifInterface.mAttributes[3].isEmpty()) {
                                exifInterface.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong((long) iArr[3], exifInterface.mExifByteOrder));
                            }
                            byteOrderedDataOutputStream2.writeUnsignedShort(i3);
                            byteOrderedDataOutputStream2.write(IDENTIFIER_EXIF_APP1);
                            byteOrderedDataOutputStream2.writeShort(exifInterface.mExifByteOrder == ByteOrder.BIG_ENDIAN ? BYTE_ALIGN_MM : BYTE_ALIGN_II);
                            byteOrderedDataOutputStream2.setByteOrder(exifInterface.mExifByteOrder);
                            byteOrderedDataOutputStream2.writeUnsignedShort(42);
                            byteOrderedDataOutputStream2.writeUnsignedInt(8);
                            for (int i6 = 0; i6 < EXIF_TAGS.length; i6++) {
                                if (!exifInterface.mAttributes[i6].isEmpty()) {
                                    byteOrderedDataOutputStream2.writeUnsignedShort(exifInterface.mAttributes[i6].size());
                                    i2 = ((iArr[i6] + 2) + (exifInterface.mAttributes[i6].size() * 12)) + 4;
                                    for (Entry entry2 : exifInterface.mAttributes[i6].entrySet()) {
                                        i4 = ((ExifTag) sExifTagMapsForWriting[i6].get(entry2.getKey())).number;
                                        ExifAttribute exifAttribute = (ExifAttribute) entry2.getValue();
                                        int size2 = exifAttribute.size();
                                        byteOrderedDataOutputStream2.writeUnsignedShort(i4);
                                        byteOrderedDataOutputStream2.writeUnsignedShort(exifAttribute.format);
                                        byteOrderedDataOutputStream2.writeInt(exifAttribute.numberOfComponents);
                                        if (size2 > 4) {
                                            byteOrderedDataOutputStream2.writeUnsignedInt((long) i2);
                                            i2 += size2;
                                        } else {
                                            byteOrderedDataOutputStream2.write(exifAttribute.bytes);
                                            if (size2 < 4) {
                                                while (size2 < 4) {
                                                    byteOrderedDataOutputStream2.writeByte(0);
                                                    size2++;
                                                }
                                            }
                                        }
                                    }
                                    if (i6 != 0 || exifInterface.mAttributes[4].isEmpty()) {
                                        byteOrderedDataOutputStream2.writeUnsignedInt(0);
                                    } else {
                                        byteOrderedDataOutputStream2.writeUnsignedInt((long) iArr[4]);
                                    }
                                    for (Entry value2 : exifInterface.mAttributes[i6].entrySet()) {
                                        ExifAttribute exifAttribute2 = (ExifAttribute) value2.getValue();
                                        if (exifAttribute2.bytes.length > 4) {
                                            byteOrderedDataOutputStream2.write(exifAttribute2.bytes, 0, exifAttribute2.bytes.length);
                                        }
                                    }
                                }
                            }
                            if (exifInterface.mHasThumbnail) {
                                byteOrderedDataOutputStream2.write(getThumbnailBytes());
                            }
                            byteOrderedDataOutputStream2.setByteOrder(ByteOrder.BIG_ENDIAN);
                            return i3;
                        }

                        private static android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat(java.lang.String r11) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = ",";
                            r0 = r11.contains(r0);
                            r1 = 0;
                            r2 = 1;
                            r3 = 2;
                            r4 = -1;
                            if (r0 == 0) goto L_0x00b1;
                        L_0x000c:
                            r0 = ",";
                            r11 = r11.split(r0);
                            r0 = r11[r1];
                            r0 = guessDataFormat(r0);
                            r1 = r0.first;
                            r1 = (java.lang.Integer) r1;
                            r1 = r1.intValue();
                            if (r1 != r3) goto L_0x0023;
                        L_0x0022:
                            return r0;
                        L_0x0023:
                            r1 = r11.length;
                            if (r2 >= r1) goto L_0x00b0;
                        L_0x0026:
                            r1 = r11[r2];
                            r1 = guessDataFormat(r1);
                            r5 = r1.first;
                            r5 = (java.lang.Integer) r5;
                            r6 = r0.first;
                            r5 = r5.equals(r6);
                            if (r5 != 0) goto L_0x0047;
                        L_0x0038:
                            r5 = r1.second;
                            r5 = (java.lang.Integer) r5;
                            r6 = r0.first;
                            r5 = r5.equals(r6);
                            if (r5 == 0) goto L_0x0045;
                        L_0x0044:
                            goto L_0x0047;
                        L_0x0045:
                            r5 = r4;
                            goto L_0x004f;
                        L_0x0047:
                            r5 = r0.first;
                            r5 = (java.lang.Integer) r5;
                            r5 = r5.intValue();
                        L_0x004f:
                            r6 = r0.second;
                            r6 = (java.lang.Integer) r6;
                            r6 = r6.intValue();
                            if (r6 == r4) goto L_0x007a;
                        L_0x0059:
                            r6 = r1.first;
                            r6 = (java.lang.Integer) r6;
                            r7 = r0.second;
                            r6 = r6.equals(r7);
                            if (r6 != 0) goto L_0x0071;
                        L_0x0065:
                            r1 = r1.second;
                            r1 = (java.lang.Integer) r1;
                            r6 = r0.second;
                            r1 = r1.equals(r6);
                            if (r1 == 0) goto L_0x007a;
                        L_0x0071:
                            r1 = r0.second;
                            r1 = (java.lang.Integer) r1;
                            r1 = r1.intValue();
                            goto L_0x007b;
                        L_0x007a:
                            r1 = r4;
                        L_0x007b:
                            if (r5 != r4) goto L_0x008d;
                        L_0x007d:
                            if (r1 != r4) goto L_0x008d;
                        L_0x007f:
                            r11 = new android.util.Pair;
                            r0 = java.lang.Integer.valueOf(r3);
                            r1 = java.lang.Integer.valueOf(r4);
                            r11.<init>(r0, r1);
                            return r11;
                        L_0x008d:
                            if (r5 != r4) goto L_0x009d;
                        L_0x008f:
                            r0 = new android.util.Pair;
                            r1 = java.lang.Integer.valueOf(r1);
                            r5 = java.lang.Integer.valueOf(r4);
                            r0.<init>(r1, r5);
                            goto L_0x00ac;
                        L_0x009d:
                            if (r1 != r4) goto L_0x00ac;
                        L_0x009f:
                            r0 = new android.util.Pair;
                            r1 = java.lang.Integer.valueOf(r5);
                            r5 = java.lang.Integer.valueOf(r4);
                            r0.<init>(r1, r5);
                        L_0x00ac:
                            r2 = r2 + 1;
                            goto L_0x0023;
                        L_0x00b0:
                            return r0;
                        L_0x00b1:
                            r0 = "/";
                            r0 = r11.contains(r0);
                            r5 = 0;
                            if (r0 == 0) goto L_0x0122;
                        L_0x00bb:
                            r0 = "/";
                            r11 = r11.split(r0);
                            r0 = r11.length;
                            if (r0 != r3) goto L_0x0114;
                        L_0x00c4:
                            r0 = r11[r1];	 Catch:{ NumberFormatException -> 0x0114 }
                            r0 = java.lang.Double.parseDouble(r0);	 Catch:{ NumberFormatException -> 0x0114 }
                            r0 = (long) r0;	 Catch:{ NumberFormatException -> 0x0114 }
                            r11 = r11[r2];	 Catch:{ NumberFormatException -> 0x0114 }
                            r7 = java.lang.Double.parseDouble(r11);	 Catch:{ NumberFormatException -> 0x0114 }
                            r7 = (long) r7;	 Catch:{ NumberFormatException -> 0x0114 }
                            r11 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0114 }
                            r2 = 10;	 Catch:{ NumberFormatException -> 0x0114 }
                            if (r11 < 0) goto L_0x0106;	 Catch:{ NumberFormatException -> 0x0114 }
                        L_0x00d8:
                            r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0114 }
                            if (r11 >= 0) goto L_0x00dd;	 Catch:{ NumberFormatException -> 0x0114 }
                        L_0x00dc:
                            goto L_0x0106;	 Catch:{ NumberFormatException -> 0x0114 }
                        L_0x00dd:
                            r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;	 Catch:{ NumberFormatException -> 0x0114 }
                            r11 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0114 }
                            r0 = 5;	 Catch:{ NumberFormatException -> 0x0114 }
                            if (r11 > 0) goto L_0x00f8;	 Catch:{ NumberFormatException -> 0x0114 }
                        L_0x00e5:
                            r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0114 }
                            if (r11 <= 0) goto L_0x00ea;	 Catch:{ NumberFormatException -> 0x0114 }
                        L_0x00e9:
                            goto L_0x00f8;	 Catch:{ NumberFormatException -> 0x0114 }
                        L_0x00ea:
                            r11 = new android.util.Pair;	 Catch:{ NumberFormatException -> 0x0114 }
                            r1 = java.lang.Integer.valueOf(r2);	 Catch:{ NumberFormatException -> 0x0114 }
                            r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0114 }
                            r11.<init>(r1, r0);	 Catch:{ NumberFormatException -> 0x0114 }
                            return r11;	 Catch:{ NumberFormatException -> 0x0114 }
                        L_0x00f8:
                            r11 = new android.util.Pair;	 Catch:{ NumberFormatException -> 0x0114 }
                            r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0114 }
                            r1 = java.lang.Integer.valueOf(r4);	 Catch:{ NumberFormatException -> 0x0114 }
                            r11.<init>(r0, r1);	 Catch:{ NumberFormatException -> 0x0114 }
                            return r11;	 Catch:{ NumberFormatException -> 0x0114 }
                        L_0x0106:
                            r11 = new android.util.Pair;	 Catch:{ NumberFormatException -> 0x0114 }
                            r0 = java.lang.Integer.valueOf(r2);	 Catch:{ NumberFormatException -> 0x0114 }
                            r1 = java.lang.Integer.valueOf(r4);	 Catch:{ NumberFormatException -> 0x0114 }
                            r11.<init>(r0, r1);	 Catch:{ NumberFormatException -> 0x0114 }
                            return r11;
                        L_0x0114:
                            r11 = new android.util.Pair;
                            r0 = java.lang.Integer.valueOf(r3);
                            r1 = java.lang.Integer.valueOf(r4);
                            r11.<init>(r0, r1);
                            return r11;
                        L_0x0122:
                            r0 = java.lang.Long.parseLong(r11);	 Catch:{ NumberFormatException -> 0x0173 }
                            r0 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0173 }
                            r1 = r0.longValue();	 Catch:{ NumberFormatException -> 0x0173 }
                            r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0173 }
                            r1 = 4;	 Catch:{ NumberFormatException -> 0x0173 }
                            if (r7 < 0) goto L_0x014d;	 Catch:{ NumberFormatException -> 0x0173 }
                        L_0x0133:
                            r7 = r0.longValue();	 Catch:{ NumberFormatException -> 0x0173 }
                            r9 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;	 Catch:{ NumberFormatException -> 0x0173 }
                            r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0173 }
                            if (r2 > 0) goto L_0x014d;	 Catch:{ NumberFormatException -> 0x0173 }
                        L_0x013e:
                            r0 = new android.util.Pair;	 Catch:{ NumberFormatException -> 0x0173 }
                            r2 = 3;	 Catch:{ NumberFormatException -> 0x0173 }
                            r2 = java.lang.Integer.valueOf(r2);	 Catch:{ NumberFormatException -> 0x0173 }
                            r1 = java.lang.Integer.valueOf(r1);	 Catch:{ NumberFormatException -> 0x0173 }
                            r0.<init>(r2, r1);	 Catch:{ NumberFormatException -> 0x0173 }
                            return r0;	 Catch:{ NumberFormatException -> 0x0173 }
                        L_0x014d:
                            r7 = r0.longValue();	 Catch:{ NumberFormatException -> 0x0173 }
                            r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0173 }
                            if (r0 >= 0) goto L_0x0165;	 Catch:{ NumberFormatException -> 0x0173 }
                        L_0x0155:
                            r0 = new android.util.Pair;	 Catch:{ NumberFormatException -> 0x0173 }
                            r1 = 9;	 Catch:{ NumberFormatException -> 0x0173 }
                            r1 = java.lang.Integer.valueOf(r1);	 Catch:{ NumberFormatException -> 0x0173 }
                            r2 = java.lang.Integer.valueOf(r4);	 Catch:{ NumberFormatException -> 0x0173 }
                            r0.<init>(r1, r2);	 Catch:{ NumberFormatException -> 0x0173 }
                            return r0;	 Catch:{ NumberFormatException -> 0x0173 }
                        L_0x0165:
                            r0 = new android.util.Pair;	 Catch:{ NumberFormatException -> 0x0173 }
                            r1 = java.lang.Integer.valueOf(r1);	 Catch:{ NumberFormatException -> 0x0173 }
                            r2 = java.lang.Integer.valueOf(r4);	 Catch:{ NumberFormatException -> 0x0173 }
                            r0.<init>(r1, r2);	 Catch:{ NumberFormatException -> 0x0173 }
                            return r0;
                        L_0x0173:
                            java.lang.Double.parseDouble(r11);	 Catch:{ NumberFormatException -> 0x0186 }
                            r11 = new android.util.Pair;	 Catch:{ NumberFormatException -> 0x0186 }
                            r0 = 12;	 Catch:{ NumberFormatException -> 0x0186 }
                            r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0186 }
                            r1 = java.lang.Integer.valueOf(r4);	 Catch:{ NumberFormatException -> 0x0186 }
                            r11.<init>(r0, r1);	 Catch:{ NumberFormatException -> 0x0186 }
                            return r11;
                        L_0x0186:
                            r11 = new android.util.Pair;
                            r0 = java.lang.Integer.valueOf(r3);
                            r1 = java.lang.Integer.valueOf(r4);
                            r11.<init>(r0, r1);
                            return r11;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.media.ExifInterface.guessDataFormat(java.lang.String):android.util.Pair<java.lang.Integer, java.lang.Integer>");
                        }

                        private void swapBasedOnImageSize(int i, int i2) throws IOException {
                            if (!this.mAttributes[i].isEmpty()) {
                                if (!this.mAttributes[i2].isEmpty()) {
                                    ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes[i].get(TAG_IMAGE_LENGTH);
                                    ExifAttribute exifAttribute2 = (ExifAttribute) this.mAttributes[i].get(TAG_IMAGE_WIDTH);
                                    ExifAttribute exifAttribute3 = (ExifAttribute) this.mAttributes[i2].get(TAG_IMAGE_LENGTH);
                                    ExifAttribute exifAttribute4 = (ExifAttribute) this.mAttributes[i2].get(TAG_IMAGE_WIDTH);
                                    if (exifAttribute != null) {
                                        if (exifAttribute2 != null) {
                                            if (exifAttribute3 != null) {
                                                if (exifAttribute4 != null) {
                                                    int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                                                    int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
                                                    int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
                                                    int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
                                                    if (intValue < intValue3 && intValue2 < intValue4) {
                                                        HashMap hashMap = this.mAttributes[i];
                                                        this.mAttributes[i] = this.mAttributes[i2];
                                                        this.mAttributes[i2] = hashMap;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        private static void closeQuietly(java.io.Closeable r0) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            if (r0 == 0) goto L_0x0008;
                        L_0x0002:
                            r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
                            goto L_0x0008;
                        L_0x0006:
                            r0 = move-exception;
                            throw r0;
                        L_0x0008:
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.media.ExifInterface.closeQuietly(java.io.Closeable):void");
                        }

                        private static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
                            byte[] bArr = new byte[8192];
                            int i = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    return i;
                                }
                                i += read;
                                outputStream.write(bArr, 0, read);
                            }
                        }

                        private static long[] convertToLongArray(Object obj) {
                            if (!(obj instanceof int[])) {
                                return obj instanceof long[] ? (long[]) obj : null;
                            } else {
                                int[] iArr = (int[]) obj;
                                long[] jArr = new long[iArr.length];
                                for (int i = 0; i < iArr.length; i++) {
                                    jArr[i] = (long) iArr[i];
                                }
                                return jArr;
                            }
                        }
                    }
