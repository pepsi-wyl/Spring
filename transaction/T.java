    

    @Test
    public void t4(){
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        UserService userService = context.getBean("userService", UserService.class);
        userService.add_del();
    }
