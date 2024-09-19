using TestCaseTechniques;

namespace Tests
{
    [TestClass]
    public class ErrorGuessingTests
    {
        [DataTestMethod]
        [DynamicData(nameof(GetTestCases), DynamicDataSourceType.Method)]
        public void TestIsErrorProne(string input, bool expected)
        {
            var eg = new ErrorGuessing();
            Assert.AreEqual(expected, eg.IsErrorProne(input));
        }

        public static IEnumerable<object[]> GetTestCases()
        {
            foreach (var line in File.ReadLines("./TestCases/IsErrorProneTestCases.csv").Skip(1))
            {
                var parts = line.Split(';');
                yield return new object[] { parts[0], bool.Parse(parts[1]) };
            }
        }
    }
}