package com.revature.util;

import com.revature.beans.Customer;

public class AppState {

    private static Customer currentCustomer;
    private static boolean appRunning;
    private static boolean restartingApp;
    
    private AppState() {
        super();
    }

    public static Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public static void setCurrentCustomer(Customer currentCustomer) {
        AppState.currentCustomer = currentCustomer;
    }

    public static boolean isAppRunning() {
        return appRunning;
    }

    public static void setAppRunning(boolean appRunning) {
        AppState.appRunning = appRunning;
    }

    
    
}