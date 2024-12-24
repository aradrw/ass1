import java.util.ArrayList;
import java.util.List;

public class school {
    private List<person> members;

    public school() {
        this.members = new ArrayList<>();
    }

    public void addMember(person person) {
        if (person != null) {
            members.add(person);
        } else {
            System.out.println("Cannot add a null member.");
        }
    }

    public List<person> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("School Members:\n");
        for (person member : members) {
            result.append(member.toString()).append("\n");
        }
        return result.toString();
    }
}
