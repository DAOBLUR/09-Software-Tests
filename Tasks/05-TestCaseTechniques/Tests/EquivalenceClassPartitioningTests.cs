using TestCaseTechniques;

namespace Tests
{
    [TestClass]
    public class EquivalenceClassPartitioningTests
    {
        [DataTestMethod]
        [DynamicData(nameof(GetTestCases), DynamicDataSourceType.Method)]
        public void TestIsValidUsername(string username, bool expected)
        {
            var validator = new EquivalenceClassPartitioning();
            Assert.AreEqual(expected, validator.IsValidUsername(username));
        }

        public static IEnumerable<object[]> GetTestCases()
        {
            var path = Path.Combine(Directory.GetCurrentDirectory(), "TestCases", "UsernameTestCases.csv");
            foreach (var line in File.ReadLines(path).Skip(1))
            {
                var parts = line.Split(';');
                yield return new object[] { parts[0], bool.Parse(parts[1]) };
            }
        }
    }
}
