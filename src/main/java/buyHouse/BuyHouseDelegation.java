package buyHouse;

/**
 * 委托人
 * Delegation：委托的意思
 * 好比我们自己
 */
public class BuyHouseDelegation implements IBuyHouse{

    @Override
    public void buyHouse() {
        System.out.println("步骤一：找房源");
        System.out.println("步骤二：谈判");
        System.out.println("步骤三：过户办理");
    }
}
