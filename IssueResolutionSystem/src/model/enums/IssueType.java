package model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum IssueType {

    PAYMENT_RELATED ("Payment Related"),
    GOLD_RELATED ("Gold Related"),
    PURCHASE_RELATED ("Purchase Related"),
    MUTUAL_FUND_RELATED ("Mutual Fund Related");

    private final String issueType;

    IssueType(String issueType) {
        this.issueType = issueType;

    }

    public String getIssueType() {
        return issueType;
    }

    public static IssueType fromString(String type) {
        Optional<IssueType> issueType = Arrays.stream(IssueType.values())
                .filter(is -> is.issueType.equals(type)).findFirst();

        return issueType.get();
    }


}
