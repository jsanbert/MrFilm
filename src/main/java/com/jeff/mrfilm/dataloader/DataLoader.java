package com.jeff.mrfilm.dataloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    /*
    DECLARE REPOS

    private Repo1 repo1;
    private Repo2 repo2;
    ...
    */

    @Autowired
    public DataLoader(/* Repo1 repo1, Repo2 repo2 ... */) {
        /*

        INITIALIZE REPOS

        this.repo1 = repo1;
        this.repo2 = repo2;
        ...

        */
    }

    public void run(ApplicationArguments args) {
        /*
        INSERT ITEMS

        ItemRepo1 item = new ItemRepo1(.....);
        repo1.insert(item);
        ...

         */
    }
}