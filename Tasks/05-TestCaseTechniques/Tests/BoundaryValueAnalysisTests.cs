using TestCaseTechniques;

namespace Tests
{
    [TestClass]
    public class BoundaryValueAnalysisTests
    {
        [DataTestMethod]
        [DynamicData(nameof(GetTestCases), DynamicDataSourceType.Method)]
        public void TestIsWithinBoundary(int value, int lowerBound, int upperBound, bool expected)
        {
            var bva = new BoundaryValueAnalysis();
            Assert.AreEqual(expected, bva.IsWithinBoundary(value, lowerBound, upperBound));
        }

        public static IEnumerable<object[]> GetTestCases()
        {
            foreach (var line in File.ReadLines("./TestCases/IsWithinBoundaryTestCases.csv").Skip(1))
            {
                var parts = line.Split(';');
                yield return new object[] { int.Parse(parts[0]), int.Parse(parts[1]), int.Parse(parts[2]), bool.Parse(parts[3]) };
            }
        }
    }
}