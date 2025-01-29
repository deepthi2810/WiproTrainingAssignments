package lms;

public class Member {
    private String memberId;
    private String name;
    private String contactNumber;
    private String email;

    public Member() {}

    public Member(String memberId, String name, String contactNumber, String email) {
        this.memberId = memberId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", name=" + name + ", contactNumber=" + contactNumber + ", email=" + email + "]";
    }
}
