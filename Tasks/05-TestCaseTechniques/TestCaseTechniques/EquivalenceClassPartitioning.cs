namespace TestCaseTechniques
{
    public class EquivalenceClassPartitioning
    {
        public bool IsValidUsername(string username)
        {
            if (string.IsNullOrEmpty(username))
            {
                return false;
            }
            if (username.Length < 5 || username.Length > 20)
            {
                return false;
            }
            foreach (char c in username)
            {
                if (!char.IsLetterOrDigit(c))
                {
                    return false;
                }
            }
            return true;
        }
    }
}