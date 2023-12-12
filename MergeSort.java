/**
 * Am implementation of MergeSort
 * 
 * @author Rhys Walker
 * @version 1.1
 * @since 2023-12-11
 */

 import java.util.ArrayList;

public class MergeSort{

    // |------------------------------------------------------|
    // |                     FOR INTEGERS                     |
    // |------------------------------------------------------|

    /**
     * A function that sorts an ArrayList containing integers
     * @param listToSort The list that is going to be sorted
     * @return A sorted list
     */
    public ArrayList<Integer> mergeSort(ArrayList<Integer> listToSort){

        // get the length of the list
        int length = listToSort.size();

        // if reached size 1 then we are at minimum size and must start merging.
        if (length == 1){
            return listToSort;
        }

        // calculate half so we can work out what index to swap on
        int half = (length+1)/2; // adding  and div by two to make it round up

        // create arrays to add to for each side
        ArrayList<Integer> feedingLeft = new ArrayList<Integer>();
        ArrayList<Integer> feedingRight = new ArrayList<Integer>();

        // loop over the main array and add to the side that is needed
        for (int index = 0; index < listToSort.size(); index++){
            if (index <= half-1){ // add to list to be sent left
                feedingLeft.add(listToSort.get(index));
            }
            else if(index > half-1){ // add to list to be sent right
                feedingRight.add(listToSort.get(index));
            }
        }

        // recursively call the mergeSort function to split list
        ArrayList<Integer> leftHalf = mergeSort(feedingLeft);
        ArrayList<Integer> rightHalf = mergeSort(feedingRight);

        // merge the lists together
        ArrayList<Integer> sortedList = merge(leftHalf, rightHalf);

        return sortedList;
    }

    /**
     * A function to merge the ArrayLists containing integers
     * @param listToMerge The individual lists that we are going to merge
     * @return The merged lists
     */
    private ArrayList<Integer> merge(ArrayList<Integer> leftHalf, ArrayList<Integer> rightHalf){

        // define the sorted list
        ArrayList<Integer> sortedList = new ArrayList<Integer>();

        // define the indexs for both sides of the merge
        int leftIndex = 0;
        int rightIndex = 0;

        // failing because once we add the last item from the list we have an index above what we should have

        // loop over for the length of both lists to calculate 
        while (leftIndex<leftHalf.size() || rightIndex<rightHalf.size()){

            // if the index is out of range then we must just add the rest of the list thats left
            if(leftIndex >= leftHalf.size() || rightIndex >= rightHalf.size()){

                if(leftIndex >= leftHalf.size()){ // if left index is out of range we need to add the rest of right

                    while (rightIndex<rightHalf.size()){ // add whats left
                        sortedList.add(rightHalf.get(rightIndex));
                        rightIndex++;
                    }

                }
                else{ // if not left then right

                    while (leftIndex<leftHalf.size()){ // add whats left
                        sortedList.add(leftHalf.get(leftIndex));
                        leftIndex++;
                    }

                }

            }
            else{ // executes as long as one index is no longer out of range

                if (leftHalf.get(leftIndex) < rightHalf.get(rightIndex)){
                    // add to the sorted list
                    sortedList.add(leftHalf.get(leftIndex));
                    // incremement counters
                    leftIndex++;
                }

                // if left is not smaller then right is
                else{
                    // add to the sorted list
                    sortedList.add(rightHalf.get(rightIndex));
                    // increment counters
                    rightIndex++;

                }
            }
        }

        // return it sorted
        return sortedList;

    }
}