    /**
     * dao层测试
     */
    @Test
    public void dao_T() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext("applicationContext");
        MysqlUserDaoImpl mysql = (MysqlUserDaoImpl) context.getBean("mysql");
        System.out.println(mysql.getDate());
        OracleUserDaoImpl oracle = (OracleUserDaoImpl) context.getBean("oracle");
        System.out.println(oracle.getDate());
    }

    /**
     * service层测试
     */
    @Test
    public void service_T() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext("applicationContext");
        UserService userService = (UserService) context.getBean("userService");
        userService.printf();
    }
