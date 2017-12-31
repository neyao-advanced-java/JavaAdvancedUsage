package org.oursight.neyao.java.advanced.streamapi;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by yaonengjun on 2017/12/31 下午4:09.
 */
public class ListAsStream {

  public static void main(String[] args) {

    Pair pair = Pair.of(11, "aaa");
    System.out.println(pair.getLeft());
    System.out.println(pair.getRight());
    System.out.println(pair.getKey());
    System.out.println(pair.getValue());

    List<User> userList = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      User user = new User();
      user.setId(i);
      user.setUserName("userName" + i);
      user.setEmail("email" +i +"@qq.com");
      user.setQq(i+"@qq.com");
      userList.add(user);
    }

    Set set = userList.stream().map(user -> Pair.of(user.getId(), user)).collect(Collectors.toSet());
    System.out.println(set);
  }
}
