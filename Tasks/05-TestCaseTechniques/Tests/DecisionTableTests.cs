using TestCaseTechniques;

namespace Tests
{
    [TestClass]
    public class DecisionTableTests
    {
        [DataTestMethod]
        [DynamicData(nameof(GetTestCases), DynamicDataSourceType.Method)]
        public void TestIsLoginSuccessful(bool isUsernameCorrect, bool isPasswordCorrect, bool isCaptchaCorrect, bool expected)
        {
            var validator = new DecisionTable();
            Assert.AreEqual(expected, validator.IsLoginSuccessful(isUsernameCorrect, isPasswordCorrect, isCaptchaCorrect));
        }

        public static IEnumerable<object[]> GetTestCases()
        {
            var path = Path.Combine(Directory.GetCurrentDirectory(), "TestCases", "LoginTestCases.csv");
            foreach (var line in File.ReadLines(path).Skip(1))
            {
                var parts = line.Split(';');
                yield return new object[] { bool.Parse(parts[0]), bool.Parse(parts[1]), bool.Parse(parts[2]), bool.Parse(parts[3]) };
            }
        }
    }
}