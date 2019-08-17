package com.kodilla.patterns2.observer.homework;

import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class MentorTest {

    @Test
    public void testUpdate() {
        //Given
        Trainee johnSmith = new Trainee("John Smith");
        Trainee adamWest = new Trainee("Adam West");
        Trainee annaNowak = new Trainee("Anna Nowak");

        Mentor janKowalski = new Mentor("Jan Kowalski");
        Mentor robertKubica = new Mentor("Robert Kubica");

        johnSmith.addObserver(janKowalski);
        adamWest.addObserver(janKowalski);
        johnSmith.addObserver(robertKubica);
        adamWest.addObserver(robertKubica);
        annaNowak.addObserver(robertKubica);

        //When
        johnSmith.addTask("Queue Task");
        adamWest.addTask("Spring Boot");
        adamWest.addTask("Hibernate");
        annaNowak.addTask("For loop");

        //Then
        assertThat(janKowalski.getUpdateCount()).isEqualTo(3);
        assertThat(robertKubica.getUpdateCount()).isEqualTo(4);
    }
}
