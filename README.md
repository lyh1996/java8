# Java8的一些特性编写的案例，和平时遇到的一些小问题的总结



JDK8常用的方式   ：

当循环遍历中不需要进行数据库操作时，使用stream()或普通循环来遍历。
当循环遍历中需要进行数据库操作时，使用parallelStream()来遍历，但是要注意多线程安全。

User user = User.builder().age(12).name("lyh").build();
        User user2 = User.builder().age(11).build();
        User user4 = User.builder().age(13).build();
        User user3 = User.builder().age(12).name("lyh").build();
        User user5 = User.builder().age(13).build();
        User user6 = User.builder().age(16).build();
1.生成List对象   
List<User> list = Stream.of(user, user2, user4).collect(Collectors.toList());
List<User> list2 = Stream.of(user3, user5, user6).collect(Collectors.toList());

2.根据指定属性进行删除：
 list2.forEach(s -> { list.removeIf(entity -> entity.getAge().equals(s.getAge())); });
 
 
3.将相同属性的List对象进行合并  如果只是单纯的合并 推荐使用addAll   （Function.identity()主要是用来表明操作的对象是同类型）
 List<User> list3 = Stream.of(list.stream(), list2.stream()).flatMap(Function.identity()).collect(Collectors.toList());

4.去除重复对象全部属性相同
List<User> aa = listuser.stream().distinct().collect(Collectors.toList());

5去除重复的对象(根据指定属性)
list3 = list3.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(User::getName))), ArrayList::new));

6.List<Object>变String ，以指定符号进行拼接
 String names = list1.stream().map(JSON::toJSONString).collect(Collectors.joining("|"));
 
7.将String转换成List<String> 以指定符号分割
List<String> list3 = Arrays.stream(names.split("\\|")).map(String::trim).collect(Collectors.toList());

将String变成List<Long>
private List<Long> stringToLongList (String strArr){
        return Arrays.stream(strArr.split(","))
                .map(s -> Long.parseLong(s.trim()))
                .collect(Collectors.toList());

8.数组变List
String[] arrays = new String[]{"a", "b", "c"};
List<String> listStrings = Stream.of(arrays).collector(Collectors.toList());

（2）String[] arrays = new String[]{"a", "b", "c"};
     List<String> listStrings = Arrays.asList(arrays); //注意List对象只有查看，不能进行增删改

9.List变数组
使用Stream:
String[] ss = listStrings.stream().toArray(String[]::new);
 
使用List中的toArray()方法
String[] sss = listStrings.toArray(new String[listStrings.size()]);

10.filter 过滤操作
List<Student> whuStudents = students.stream().filter(student -> "武汉大学".equals(student.getSchool())).collect(Collectors.toList());

11.limit只需要前2个
List<Student> civilStudents = students.stream()
                                    .filter(student -> "土木工程".equals(student.getMajor())).limit(2)
                                    .collect(Collectors.toList());
Map操作  
                                
12.将对象属性变成List
List<Integer> getAllages(List<User>userlist){
        return  userlist.stream().map(user -> user.getAge()).collect(Collectors.toList());
    }
    
13.将对象属性变成set实现去重
public static Set<Integer> getAllagesSET(List<User>userlist){
        return  userlist.stream().map(user -> user.getAge()).collect(Collectors.toSet());
    }
    
14.把对象变成Map  键和值 分别来源于属性 
    public static Map<Integer,String> getUser2Map(List<User>userlist){
        return userlist.stream().collect(Collectors.toMap(User::getAge,User::getName));
    }
    
15.把对象变成Map  键来源于属性
    public static Map<Integer,User> getUser2MapUser(List<User>userlist){
    return userlist.stream().collect(Collectors.toMap(User::getAge,User-> User));
    }
    
16.把对象变成Map   比较优雅的写法是这样的
    public static Map<Integer,User> getUser2MapUser2(List<User>userlist){
        return userlist.stream().collect(Collectors.toMap(User::getAge, Function.identity()));
    }
    
17.重复key的情况下 简单的使用后者覆盖前者的
    public static Map<Integer,User> getUser2MapUser3(List<User>userlist){
        return userlist.stream().collect(Collectors.toMap(User::getAge, Function.identity(),(key1,key2)->key2));
    }
  
18.指定map类型的具体实现
    public static Map<Integer,User> getUser2MapUser4(List<User>userlist){
        return userlist.stream().collect(Collectors.toMap(User::getAge, Function.identity(),(key1,key2)->key2, LinkedHashMap::new));
    }
    
19.变成分组Map
Map<Integer, List<User>> map = list.stream().collect(Collectors.groupingBy(User::getAge));

20.特殊的Map  键根据条件来设置
Map<Boolean, List<User>> isMap = list.stream().collect(Collectors.partitioningBy(u -> u.getAge() > 12 ));

21.Map的迭代
isMap.forEach((k,v) -> {
            System.out.println("键：" + k);
            System.out.println("值：" + v);
        });




 public static <T, V> Set<T> toSet(Collection<V> collection, Function<V, T> f) {
        if (CollectionUtils.isNotEmpty(collection)) {
            return toStream(collection, f).collect(Collectors.toSet());
        } else {
            return Collections.emptySet();
        }
    }

    public static <T, V> List<T> toList(Collection<V> collection, Function<V, T> f) {
        if (CollectionUtils.isNotEmpty(collection)) {
            return toStream(collection, f).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public static <T, K, V> Map<K, V> toMap(Collection<T> collection, Function<T, K> key, Function<T, V> value) {
        if (CollectionUtils.isNotEmpty(collection)) {
            return collection.stream().collect(Collectors.toMap(key, value, (o, n) -> o));
        } else {
            return Collections.emptyMap();
        }
    }

    public static <T, K> Map<K, T> toMapIdentity(Collection<T> collection, Function<T, K> key) {
        if (CollectionUtils.isNotEmpty(collection)) {
            return collection.stream().collect(Collectors.toMap(key, Function.identity(), (o, n) -> o));
        } else {
            return Collections.emptyMap();
        }
    }

    private static <K, V> Stream<K> toStream(Collection<V> collection, Function<V, K> f) {
        return toStream(collection, f, false);
    }

    private static <K, V> Stream<K> toStream(Collection<V> collection, Function<V, K> f, boolean parallel) {
        Stream<K> kStream = collection.stream().filter(Objects::nonNull).map(f).filter(Objects::nonNull);
        return parallel ? kStream.parallel() : kStream;
    }
    
    
     //求最大值
            BigDecimal max = userList.stream().map(User::getWeight).max((x1, x2) -> x1.compareTo(x2)).get();
            //求最小值
            BigDecimal min = userList.stream().map(User::getWeight).min((x1, x2) -> x1.compareTo(x2)).get();
            //求和
            BigDecimal sum = userList.stream().map(User::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
            //求平均值
            BigDecimal average = userList.stream().map(User::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(userList.size()), 2, BigDecimal.ROUND_HALF_UP);

//排序操作
            results = results.stream().sorted(Comparator.comparing(DivideDTO::getLendRate)).collect(Collectors.toList());

    /**
    * 将对象属性转化为map结合
    */
    public static <T> Map<Object, Object> beanToMap(T bean) {
     Map<Object, Object> map = new HashMap<>();
     if (bean != null) {
      BeanMap beanMap = BeanMap.create(bean);
      for (Object key : beanMap.keySet()) {
       map.put(key, beanMap.get(key));
      }
     }
     return map;
    }
    
    /**
    * 移除map中的value空值
    *
    * @param map
    * @return
    */
    public static void removeNullValue(Map map) {
     Set set = map.keySet();
     for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
      Object obj = (Object) iterator.next();
      Object value = (Object) map.get(obj);
      remove(value, iterator);
     }
    }