package wiprotraining;

public class PrimitiveVsReferenc {
    public static void main(String[] args) {
        // Primitive variable example
        int primitiveA = 10;
        int primitiveB = primitiveA; // Copy value of primitiveA into primitiveB
        System.out.println("Primitive Variables:");
        System.out.println("Before changing primitiveA:");
        System.out.println("primitiveA = " + primitiveA);
        System.out.println("primitiveB = " + primitiveB);

        primitiveA = 20; // Change primitiveA
        System.out.println("After changing primitiveA:");
        System.out.println("primitiveA = " + primitiveA); // Only primitiveA is affected
        System.out.println("primitiveB = " + primitiveB); // primitiveB remains unchanged

        // Reference variable example
        int[] referenceA = {1, 2, 3}; // Create an array (object in memory)
        int[] referenceB = referenceA; // ReferenceB points to the same object as referenceA
        System.out.println("\nReference Variables:");
        System.out.println("Before changing referenceA:");
        System.out.println("referenceA[0] = " + referenceA[0]);
        System.out.println("referenceB[0] = " + referenceB[0]);

        referenceA[0] = 10; // Modify the object through referenceA
        System.out.println("After changing referenceA:");
        System.out.println("referenceA[0] = " + referenceA[0]); // Both references are affected
        System.out.println("referenceB[0] = " + referenceB[0]); // Reflects the change
    }
}
