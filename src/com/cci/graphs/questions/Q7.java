package com.cci.graphs.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q7 {

    public static void main(String[] args) {

        Project project1 = new Project(1, "d", null);

        Project project2 = new Project(1, "a", Arrays.asList(project1));
        Project project3 = new Project(1, "b", Arrays.asList(project2));

        ArrayList<Project> projects = new ArrayList<>();
        projects.add(project1);
        projects.add(project2);
        projects.add(project3);

        System.out.println(getBuildOrder((projects)));


    }

    static ArrayList<Project> getBuildOrder(ArrayList<Project> projects) {

        ArrayList<Project> processedProjects = new ArrayList<>();
        ArrayList<Project> toBeProcessedProjects = new ArrayList<>();

        for (Project project : projects) {
            if (project.dependencies == 0) {
                toBeProcessedProjects.add(project);
                break;
            }


        }

        if (toBeProcessedProjects.size() == 0) {
            return null;
        }

        int counter = 0;
        while (toBeProcessedProjects.size() > 0) {
            Project project = toBeProcessedProjects.get(counter);
            if (project.dependencies == 0) {
                processedProjects.add(project);
                toBeProcessedProjects.remove(project);
                counter--;
                if (null != project.children) {
                    for (Project child : project.children) {
                        child.dependencies--;
                        if (child.dependencies == 0) {
                            toBeProcessedProjects.add(child);
                        }
                    }
                }
            }
            counter++;
        }
        return processedProjects;

    }
}


class Project {

    int dependencies;
    String name;
    List<Project> children = new ArrayList<>();

    public Project(int dependencies, String name, List<Project> children) {
        this.dependencies = dependencies;
        this.name = name;
        if (null != children) {
            this.children.addAll(children);

        }
    }

    @Override
    public String toString() {
        return name;
    }
}
