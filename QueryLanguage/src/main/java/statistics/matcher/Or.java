
package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {
    
    private Matcher[] matchers;
    
    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        int found = 0;
        
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                found++;
            }
        }
        
        if (found > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
}
