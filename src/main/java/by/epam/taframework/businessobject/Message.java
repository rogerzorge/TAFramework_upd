package by.epam.taframework.businessobject;

/**
 * Created by Yahor_Faliazhynski on 2/3/2016.
 */
public class Message {

    private String toField;
    private String subjectField;
    private String bodyField;

    public Message() {}

    public Message(String toField, String subjectField, String bodyField) {
        this.toField = toField;
        this.subjectField = subjectField;
        this.bodyField = bodyField;
    }

    public String getToField() {
        return this.toField;
    }

    public void setToField(String toField) {
        this.toField = toField;
    }

    public String getSubjectField() {
        return this.subjectField;
    }

    public void setSubjectField(String subjectField) {
        this.subjectField = subjectField;
    }

    public String getBodyField() {
        return this.bodyField;
    }

    public void setBodyField(String bodyField) {
        this.bodyField = bodyField;
    }

}
