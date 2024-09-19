namespace TestCaseTechniques
{
    public class BoundaryValueAnalysis
    {
        public bool IsWithinBoundary(int value, int lowerBound, int upperBound)
        {
            return value >= lowerBound && value <= upperBound;
        }
    }
}