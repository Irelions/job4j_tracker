package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.ex.User;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();

        List<UserAction> temp = new ArrayList<>();
        temp.add(action);


        new StartUI().init(input, new Tracker(), temp);
        assertThat(action.isCall(), is(true));
    }
}