/**
 * 
 */
package spelling;

import java.util.List;

/**
 * @author tanmay
 *
 */
public interface AutoComplete {
	public List<String> predictCompletions(String prefix, int numCompletions);
}
