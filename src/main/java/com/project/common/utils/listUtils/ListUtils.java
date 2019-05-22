package com.project.common.utils.listUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ListUtils {


    /**
     * 求交集
     * 具体使用方法,参照intersect方法,参数最全的那个.
     * 默认不去重.
     *
     * @param leftList
     * @param rightList
     * @param listComparator
     * @param <T>
     * @return
     */
    public static <T> List<T> intersect(List<T> leftList, List<T> rightList, ListComparator<T> listComparator) {
        return ListUtils.intersect(leftList, rightList, listComparator, false);
    }

    /**
     * 作用: 求两个集合的交集
     * 集合中的元素通过lambda表达式返回的boolean类型来判断是否相等,而不是调用元素的equals方法比较
     * <p>
     * 注意事项:
     * -----1:返回的集合为一个新的集合.和原集合不是一个对象
     * -----2:返回的集合中的元素取自左侧集合,引用地址是一个,修改值请注意!
     * -----3:集合内元素是否相同的比较公式是listComparator参数,不是equals方法.
     * -----4:在不去重的情况下:
     * -------如果是右侧集合内部重复,则无视.
     * -------如果是左侧集合内部重复,则可能返回重复的元素
     * -------以上所谓的重复是指lambda表达式返回true,则视为重复.
     * -----5:使用时一定要注意,返回的元素是左侧集合中的元素!!!!!!!!!!!!!!!!
     * -----6:去重的公式依然使用listComparator参数,如果左侧集合和右侧集合比较的参数不相同,请慎用!!!
     * <p>
     * 样例:
     * ListUtils.intersect(leftList,tightList,
     * (l,r) -> l.getId().equals(r.getId())
     * ,false)   //id可能是空指针,请自行判断....
     *
     * @param leftList       左侧集合
     * @param rightList      右侧集合
     * @param listComparator 集合中元素是否视为相同的比较规则,这是一个lambda公式
     * @param distinct       是否去重
     * @return 一个新的集合, 元素中包含输入的左集合和右集合的交集(相同的元素)
     */
    public static <T> List<T> intersect(List<T> leftList, List<T> rightList, ListComparator<T> listComparator,
                                        boolean distinct) {
        /*非空判断*/
        if (leftList == null || rightList == null || leftList.isEmpty() || rightList.isEmpty()) {
            return new ArrayList<>();
        }
        /*求交集*/
        List<T> returnList = leftList.stream().filter(
                l -> rightList.stream().anyMatch(r -> listComparator.equals(l, r))).collect(Collectors.toList());
        /*去重*/
        if (distinct) {
            ListUtils.distinct(returnList, listComparator);
        }
        return returnList;
    }


    /**
     * list去重.
     *
     * @param list
     * @param listComparator
     * @param <T>
     */
    private static <T> void distinct(List<T> list, ListComparator<T> listComparator) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (listComparator.equals(list.get(i), list.get(j))) {
                    list.remove(j);
                }
            }
        }
    }

    //@Test
    //public void test() {
    //    ArrayList<String> list = new ArrayList<>();
    //    list.add("1");
    //    list.add("2");
    //    list.add("1");
    //    list.add("3");
    //    list.add("4");
    //    list.add("2");
    //    System.out.println(list);
    //    ListUtils.distinct(list, Object::equals);
    //    System.out.println(list);
    //}


    //@Test
    //public void test1() {
    //        ArrayList<String> list = new ArrayList<>();
    //        list.add("1");
    //        list.add("2");
    //        list.add("1");
    //        list.add("3");
    //        list.add("4");
    //        list.add("2");
    //        ArrayList<String> list1 = new ArrayList<>();
    //        list1.add("5");
    //        list1.add("3");
    //        list1.add("8");
    //        list1.add("9");
    //        list1.add("2");
    //        list1.add("4");
    //    List<String> list2 = ListUtils.intersect(list, list1, Object::equals);
    //    List<String> list3 = ListUtils.intersect(list, list1, Object::equals,true);
    //    System.out.println(list2);
    //    System.out.println(list3);
    //}


}
