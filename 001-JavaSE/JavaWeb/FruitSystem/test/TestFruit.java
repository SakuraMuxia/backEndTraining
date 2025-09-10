import com.fruit.dao.FruitDao;
import com.fruit.dao.impl.FruitDaoImpl;
import com.fruit.pojo.Fruit;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class TestFruit {
    // 创建fruitDao实例
    private FruitDao fruitDao = new FruitDaoImpl();

    @Test
    public void test01 (){
        BigDecimal bigDecimal = new BigDecimal("8.00");
        Fruit fruit1 = new Fruit(0,"南瓜",bigDecimal,80,"南瓜很好吃");
        fruitDao.addFruit(fruit1);
    }

    @Test
    public void test02 (){
        List<Fruit> fruitList = fruitDao.getFruitList();
        for (Fruit fruit : fruitList) {
            System.out.println("fruit = " + fruit);
        }
    }

    @Test
    public void test03(){
        fruitDao.delFruit(9);
    }
}
