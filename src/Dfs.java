import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dfs {

    State initialState;
    int level;
    List<State> path = new ArrayList<>();
    MoveLogic moveLogic;

    Dfs(State initialState, int level) {
        this.level = level;
        this.initialState = initialState;
        path.add(initialState);
        this.moveLogic = new MoveLogic(initialState, level);
    }

    public void dfsOn() {
        System.out.println("iam in dfsOn");

        Map<Character, State> sibling = moveLogic.nexStates(false);// brings initial's children
        List<State> siblingStates = new ArrayList<>(sibling.values());
        State currenState = siblingStates.get(0);// initial's first leftsome child

        goOn(currenState, sibling);

    }

    public void goOn(State currenState, Map<Character, State> sibling) {

        // if not final so dfs still on
        if (!moveLogic.isFinal(currenState.board, true)) {

            // هل مارقة معي الستيت من قبل؟؟ طالما لا ضيفها و روح حرك عشان نوصللها ثم جيب
            // ولادها
            if (addToPathIfCan(currenState)) {

                char direction = bringStateDirection(currenState, sibling);
                moveLogic.moveAllColors(direction, false);

                // bring its children,and the leftsome of them is the new current
                sibling = moveLogic.nexStates(false);
                List<State> siblingStates = new ArrayList<>(sibling.values());
                currenState = siblingStates.get(0);

                goOn(currenState, sibling);
            } else {
                // معناتو العقدة مارقة من قبل فما بدي ياها لا هي ولا ولادها و رح انط على اخوها
                List<State> siblingStates = new ArrayList<>(sibling.values());
                int nextSiblingIndex = siblingStates.indexOf(currenState) + 1;
                if (nextSiblingIndex < siblingStates.size()) {
                    goOn(siblingStates.get(nextSiblingIndex), sibling);
                }
            }

        }

        else {
            // its final
            System.out.println("it is final wow");
            addToPathIfCan(currenState);
            char direction = bringStateDirection(currenState, sibling);
            moveLogic.moveAllColors(direction, true);
            System.out.println("The Path of Dfs wassssssssssssssssssssssssssssssssssssssssssssssssss");
            moveLogic.printPath(path);
            return;
        }
    }

    public char bringStateDirection(State s, Map<Character, State> sibling) {
        for (Character key : sibling.keySet()) {
            if (sibling.get(key).equals(s)) {
                return key;
            }
        }
        return ' ';
    }

    public boolean addToPathIfCan(State state) {
        if (!isInPath(state)) {
            path.add(state);
            return true;
        }
        return false;
    }

    public boolean isInPath(State state) {
        for (State p : path) {
            if (moveLogic.isEqual(p, state)) {
                return true;
            }
        }
        return false;
    }
}
















































//8,1,2,4