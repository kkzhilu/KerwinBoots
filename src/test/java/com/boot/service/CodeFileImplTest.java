package com.boot.service;

import com.boot.ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Enzo Cotter on 2019/12/7.
 */
public class CodeFileImplTest extends ApplicationTests {

    @Autowired
    CodeFileImpl file;

    @Test
    public void getCount() {
        System.out.println(file.getCount());
    }

    @Test
    public void select() {
        System.out.println(file.select());
    }

    @Test
    public void selectPage() {
        System.out.println(file.selectPage(2,1));
    }
}