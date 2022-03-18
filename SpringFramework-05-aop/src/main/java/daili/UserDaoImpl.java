package daili;

/**
 * @author by pepsi-wyl
 * @date 2022-01-23 16:58
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
