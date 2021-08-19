package jjh.api.customer.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MyPredicateTest {

    @Test
    void test1() {
        List<String> list = new ArrayList<>();
        list.add("Bithumb");
        list.add("");
        list.add("kakaoTalk");
        list.add("");
        list.add("Bitcamp");
        Predicate<String> predicate = s -> !s.isEmpty();
        List<String> newList = filterList(list,predicate);
        //assertThat(newList, is(equalTo(Arrays.asList("Bithumb","kakaoTalk","Bitcamp"))));
        Predicate<String> filter = s -> s.contains("Talk");
        List<String> talkList = filterList(list,filter);
//        assertThat(talkList,is(equalTo(Arrays.asList("kakaoTalk"))));

        Predicate<String> BitFilter = s -> s.contains("Bit");
        List<String> bitList = filterList(list,BitFilter);
//        assertThat(bitList,is(equalTo(Arrays.asList("Bithumb","Bitcamp"))));

        List<Integer> intList = Arrays.asList(1,4,6,7,8);
        Predicate<Integer> IntegerFilter = e -> e % 2 == 0;
        List<Integer> IntegerList = filterList(intList, IntegerFilter);
        assertThat(IntegerList,is(equalTo(Arrays.asList(4,6,8))));

    }
    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for(T str : list){
            if (predicate.test(str)) {
                newList.add(str);
            }
        }
        return newList;
    }
}