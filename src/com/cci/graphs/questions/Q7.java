package com.cci.graphs.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q7 {

    public static void main(String[] args) {
        Project f = new Project(2, "f", null);

        Project a = new Project(1, "a", Arrays.asList(f));

        Project b = new Project(1, "b", Arrays.asList(f));
        Project d = new Project(1, "d", Arrays.asList(b, a));

        Project c = new Project(0, "c", Arrays.asList(d));
        Project e = new Project(0, "e", null);

        ArrayList<Project> projects = new ArrayList<>();
        projects.add(a);
        projects.add(b);
        projects.add(c);
        projects.add(d);
        projects.add(e);
        projects.add(f);

        System.out.println(getBuildOrder((projects)));


    }

    static ArrayList<Project> getBuildOrder(ArrayList<Project> projects) {

        ArrayList<Project> processedProjects = new ArrayList<>();
        ArrayList<Project> toBeProcessedProjects = new ArrayList<>();

        for (Project project : projects) {
            if (project.dependencies == 0) {
                toBeProcessedProjects.add(project);
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
