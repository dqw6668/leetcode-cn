//给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodIt
//emi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。 
//
// 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中
//的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。 
//
// 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。 
//
// 
//
// 示例 1： 
//
// 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David",
//"3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","
//Ceviche"]]
//输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1
//","0"],["5","0","1","0","1"],["10","1","0","0","0"]] 
//解释：
//点菜展示表如下所示：
//Table,Beef Burrito,Ceviche,Fried Chicken,Water
//3    ,0           ,2      ,1            ,0
//5    ,0           ,1      ,0            ,1
//10   ,1           ,0      ,0            ,0
//对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
//而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
//餐桌 10：Corina 点了 "Beef Burrito" 
// 
//
// 示例 2： 
//
// 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],[
//"Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","
//Canadian Waffles"]]
//输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
// 
//解释：
//对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
//而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
// 
//
// 示例 3： 
//
// 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melis
//sa","2","Soda"]]
//输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= orders.length <= 5 * 10^4 
// orders[i].length == 3 
// 1 <= customerNamei.length, foodItemi.length <= 20 
// customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。 
// tableNumberi 是 1 到 500 范围内的整数。 
// 
// Related Topics 哈希表 
// 👍 19 👎 0


package editor.cn.common;


import java.util.*;

//Java：点菜展示表
public class P1418DisplayTableOfFoodOrdersInARestaurant{
    public static void main(String[] args) {
        Solution solution = new P1418DisplayTableOfFoodOrdersInARestaurant().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            // 菜单foodSet
            TreeSet<String> foodSet = new TreeSet<>();

            // 订单集合 <餐桌号，<食品名称，食品数量>>
            TreeMap<String, TreeMap<String, Integer>> orderMap = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));

            //1 遍历订单，填入相关信息
            for (List orderList : orders) {
                //1.1 获得餐桌号
                String tableNumber = (String) orderList.get(1);
                //1.2 获得食品名称
                String foodName = (String) orderList.get(2);
                //1.3 食品set里面加入食品名称
                foodSet.add(foodName);

                //1.4.1 如果不存在xx桌的订单，就创建一条订单map
                if (!orderMap.containsKey(tableNumber)) {
                    // xx食品map
                    TreeMap<String, Integer> food = new TreeMap<>();
                    food.put(foodName, 1);
                    // 将xx桌订单添加到所有订单map中
                    orderMap.put(tableNumber, food);
                } else {
                    // 1.4.2 如果xx桌子订单存在
                    TreeMap<String, Integer> foodMap = orderMap.get(tableNumber);
                    // 如果xx桌子订单中不存在xx事物，就加入
                    if (!foodMap.containsKey(foodName)) {
                        // 将食物map添加到已存在的桌子订单中
                        foodMap.put(foodName, 1);
                    } else {
                        // 如果已经存在xx事物，就将数量加1
                        foodMap.put(foodName, foodMap.get(foodName) + 1);
                    }
                }
            }
            //2、将订单map写到结果集中
            List<List<String>> result = new ArrayList<>();
            // 2.1 添加第一行标题、
            ArrayList<String> title = new ArrayList<>();
            title.add("Table");
            for (String s : foodSet) {
                title.add(s);
            }
            result.add(title);

            //2.2 遍历订单map，将信息写到结果结合
            Set<String> tables = orderMap.keySet();

            for (String tableN : tables) {
                // 根据桌号获取 食品清单
                Map foods = orderMap.get(tableN);
                // 创建一条xx桌订单list
                ArrayList<String> list = new ArrayList<>();
                // 加入桌号
                list.add(tableN);
                // 遍历foodSet，根据foodSet中的食物名称来查foods，存在就返回数量。不存在就返回0
                for (String name : foodSet) {
                    // 如果存在xx事物
                    if (foods.containsKey(name)) {
                        String foodNum = String.valueOf(foods.get(name));
                        list.add(foodNum);
                    } else {
                        // 如果没有预定xx事务，就将订单上写0
                        list.add("0");
                    }
                }
                result.add(list);
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}