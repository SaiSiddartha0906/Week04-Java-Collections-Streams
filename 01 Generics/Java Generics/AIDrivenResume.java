import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    abstract public void evaluateResume();
}


class SoftwareEngineer extends JobRole {
    private int codingExperienceYears;

    public SoftwareEngineer(String candidateName, int codingExperienceYears) {
        super(candidateName);
        this.codingExperienceYears = codingExperienceYears;
    }

    public int getCodingExperienceYears() {
        return codingExperienceYears;
    }

    @Override
    public void evaluateResume() {
        System.out.println("Software Engineer - " + getCandidateName() +
                " | Coding Experience: " + codingExperienceYears + " years");
    }
}

class DataScientist extends JobRole {
    private int machineLearningProjects;

    public DataScientist(String candidateName, int machineLearningProjects) {
        super(candidateName);
        this.machineLearningProjects = machineLearningProjects;
    }

    public int getMachineLearningProjects() {
        return machineLearningProjects;
    }

    @Override
    public void evaluateResume() {
        System.out.println("Data Scientist - " + getCandidateName() +
                " | ML Projects: " + machineLearningProjects);
    }
}

class ProductManager extends JobRole {
    private int productsManaged;

    public ProductManager(String candidateName, int productsManaged) {
        super(candidateName);
        this.productsManaged = productsManaged;
    }

    public int getProductsManaged() {
        return productsManaged;
    }

    @Override
    public void evaluateResume() {
        System.out.println("Product Manager - " + getCandidateName() +
                " | Products Managed: " + productsManaged);
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void showResume() {
        jobRole.evaluateResume();
    }
}


class ResumeScreeningSystem {

    public static void processResumes(List<? extends JobRole> resumes) {
        System.out.println("---- Screening Resumes ----");
        for (JobRole jobRole : resumes) {
            jobRole.evaluateResume();
        }
    }
}


public class AIDrivenResume {
    public static void main(String[] args) {
        // Create individual resumes
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice", 5));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob", 3));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie", 4));

        // Create a list of resumes
        List<JobRole> resumeList = new ArrayList<>();
        resumeList.add(seResume.getJobRole());
        resumeList.add(dsResume.getJobRole());
        resumeList.add(pmResume.getJobRole());


        ResumeScreeningSystem.processResumes(resumeList);
    }
}
