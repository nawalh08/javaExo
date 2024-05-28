package org.example;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class NavigationSystem {



        private String destination;
        public void travel(NavigationStrategy navigationStrategy) {navigationStrategy.navigate(destination);}

}
