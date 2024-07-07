package org.sh.huiyi.boot.utils;

public class ModelUtil {

    public ModelUtil() {
    }

//    public static boolean modelIsExsit(BaseModel baseModel) {
//        return StringUtils.isNotBlank(baseModel.getId());
//    }
//
//    public static <T> T copyProperties(Object source, T target) {
//        try {
//            BeanUtils.copyProperties(source, target);
//            return target;
//        } catch (Exception var3) {
//            throw new ZKBusinessException("", "bean copy error");
//        }
//    }
//
//    public static <T> T copyPropertiesIgnoreId(Object source, T target) {
//        try {
//            BeanUtils.copyProperties(source, target, new String[]{"id"});
//            return target;
//        } catch (Exception var3) {
//            throw new ZKBusinessException("", "bean copy ignoreId error");
//        }
//    }
//
//    public static <T> T copyPropertiesWithIgnore(Object source, T target, String... ignoreProperties) {
//        try {
//            BeanUtils.copyProperties(source, target, ignoreProperties);
//            return target;
//        } catch (Exception var4) {
//            throw new ZKBusinessException("", "bean ignoreProperties error");
//        }
//    }
//
//    public static <T> List<T> copyListProperties(Collection list, Class<T> classs) {
//        try {
//            List<T> targetList = new ArrayList();
//            Iterator var3 = list.iterator();
//
//            while(var3.hasNext()) {
//                Object source = var3.next();
//                targetList.add(copyProperties(source, classs.newInstance()));
//            }
//
//            return targetList;
//        } catch (Exception var5) {
//            throw new ZKBusinessException("", "bean error");
//        }
//    }
//
//    public static <T> List<T> copyListPropertiesWithIgnore(Collection list, Class<T> classs, String... ignoreProperties) {
//        try {
//            List<T> targetList = new ArrayList();
//            Iterator var4 = list.iterator();
//
//            while(var4.hasNext()) {
//                Object source = var4.next();
//                targetList.add(copyPropertiesWithIgnore(source, classs.newInstance(), ignoreProperties));
//            }
//
//            return targetList;
//        } catch (Exception var6) {
//            throw new ZKBusinessException("", "bean ignoreProperties error");
//        }
//    }
//
//    public static String[] getNullPropertyNames(Object source, String... ignoreProperties) {
//        BeanWrapper src = new BeanWrapperImpl(source);
//        PropertyDescriptor[] pds = src.getPropertyDescriptors();
//        Set<String> emptyNames = new HashSet();
//        PropertyDescriptor[] var5 = pds;
//        int var6 = pds.length;
//
//        int var7;
//        for(var7 = 0; var7 < var6; ++var7) {
//            PropertyDescriptor pd = var5[var7];
//            Object srcValue = src.getPropertyValue(pd.getName());
//            if (srcValue == null) {
//                emptyNames.add(pd.getName());
//            }
//        }
//
//        String[] result;
//        if (ignoreProperties != null) {
//            result = ignoreProperties;
//            var6 = ignoreProperties.length;
//
//            for(var7 = 0; var7 < var6; ++var7) {
//                String ig = result[var7];
//                emptyNames.add(ig);
//            }
//        }
//
//        result = new String[emptyNames.size()];
//        return (String[])emptyNames.toArray(result);
//    }
//
//    public static <T> T copyPropertiesIgnoreNull(Object source, T target) {
//        return copyPropertiesWithIgnore(source, target, getNullPropertyNames(source));
//    }
//
//    public static <T> T copyPropertiesIgnoreNullWithProperties(Object source, T target, String... ignoreProperties) {
//        return copyPropertiesWithIgnore(source, target, getNullPropertyNames(source, ignoreProperties));
//    }

}
