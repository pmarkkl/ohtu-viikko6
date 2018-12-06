
package statistics.matcher;

public class QueryBuilder {
    
    Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new All();
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String fieldName) {
        this.matcher = new And(matcher, new HasAtLeast(value, fieldName));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String fieldName) {
        this.matcher = new And(matcher, new HasFewerThan(value, fieldName));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
    public Matcher build() {
        Matcher matcherToReturn = matcher;
        this.matcher = new All();
        return matcherToReturn;
    }
    
}
