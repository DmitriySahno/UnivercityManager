import org.apache.commons.lang3.StringUtils;

public class UniversityMainProfileComparator implements UniversityComparator {

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getMainProfile().toString(), o2.getMainProfile().toString());
    }
}
