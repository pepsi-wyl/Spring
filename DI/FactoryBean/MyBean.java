package FactoryBean;

import org.springframework.beans.factory.FactoryBean;
import pojo.Address;

/**
 * @author by wyl
 * @date 2021/11/1.10点19分
 */

public class MyBean implements FactoryBean<Address> {

    @Override
    public Address getObject() throws Exception {
        return new Address("安阳市");
    }

    @Override
    public Class<?> getObjectType() {
        return Address.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

}
