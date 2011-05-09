package de.akquinet.commons.image.io;

import de.akquinet.commons.image.io.ScaleHelper.Interpolation;

public class ImageIOUtils {

    private static IOHelper m_bufferedImageHelper;
    private static ScaleHelper m_defaultScaleHelper;
    private static ConversionHelper m_defaultConverter;

    public static IOHelper getIOHelper() {
        synchronized (ImageIOUtils.class) {
            if (m_bufferedImageHelper == null) {
                m_bufferedImageHelper = getFreshIOHelper();
            }
        }
        return m_bufferedImageHelper;
    }

    public static IOHelper getFreshIOHelper() {
        return new IOHelper();
    }

    public static ScaleHelper getScaleHelper() {
        synchronized (ImageIOUtils.class) {
            if (m_defaultScaleHelper == null) {
                m_defaultScaleHelper = getFreshScaleHelper(Interpolation.BILINEAR);
            }
        }
        return m_defaultScaleHelper;
    }

    public static ScaleHelper getFreshScaleHelper(Interpolation interpolation) {
        return new ScaleHelper(interpolation);
    }

    public static ConversionHelper getConverterHelper() {
        synchronized (ImageIOUtils.class) {
            if (m_defaultConverter == null) {
                m_defaultConverter = getFreshConverterHelper();
            }
        }
        return m_defaultConverter;
    }

    public static ConversionHelper getFreshConverterHelper() {
        return new ConversionHelper();
    }



}
