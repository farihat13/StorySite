package Model;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by DELL on 7/1/2017.
 */
@Entity
@Table(name = "USERPROFILE", schema = "SDPROJECT", catalog = "")
public class UserprofileEntity {
    private String writer;
    private String aboutwriter;
    private Long followcount;
    private Long currentmonthfollower;
    private String firstName;
    private String lastName;
    private Time joinedAt;
    private long bookcount;

    @Id
    @Column(name = "WRITER", nullable = false, length = 20)
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Basic
    @Column(name = "ABOUTWRITER", nullable = true, length = 4000)
    public String getAboutwriter() {
        return aboutwriter;
    }

    public void setAboutwriter(String aboutwriter) {
        this.aboutwriter = aboutwriter;
    }

    @Basic
    @Column(name = "FOLLOWCOUNT", nullable = true, precision = 0)
    public Long getFollowcount() {
        return followcount;
    }

    public void setFollowcount(Long followcount) {
        this.followcount = followcount;
    }

    @Basic
    @Column(name = "CURRENTMONTHFOLLOWER", nullable = true, precision = 0)
    public Long getCurrentmonthfollower() {
        return currentmonthfollower;
    }

    public void setCurrentmonthfollower(Long currentmonthfollower) {
        this.currentmonthfollower = currentmonthfollower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserprofileEntity that = (UserprofileEntity) o;

        if (writer != null ? !writer.equals(that.writer) : that.writer != null) return false;
        if (aboutwriter != null ? !aboutwriter.equals(that.aboutwriter) : that.aboutwriter != null) return false;
        if (followcount != null ? !followcount.equals(that.followcount) : that.followcount != null) return false;
        if (currentmonthfollower != null ? !currentmonthfollower.equals(that.currentmonthfollower) : that.currentmonthfollower != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = writer != null ? writer.hashCode() : 0;
        result = 31 * result + (aboutwriter != null ? aboutwriter.hashCode() : 0);
        result = 31 * result + (followcount != null ? followcount.hashCode() : 0);
        result = 31 * result + (currentmonthfollower != null ? currentmonthfollower.hashCode() : 0);
        return result;
    }

    @Transient
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Transient
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public Time getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Time joinedAt) {
        this.joinedAt = joinedAt;
    }

    @Transient
    public long getBookcount() {
        return bookcount;
    }

    public void setBookcount(long bookcount) {
        this.bookcount = bookcount;
    }

    @Override
    public String toString() {
        return "UserprofileEntity{" +
                "writer='" + writer + '\'' +
                ", aboutwriter='" + aboutwriter + '\'' +
                ", followcount=" + followcount +
                ", currentmonthfollower=" + currentmonthfollower +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", joinedAt=" + joinedAt +
                ", bookcount=" + bookcount +
                '}';
    }
}
