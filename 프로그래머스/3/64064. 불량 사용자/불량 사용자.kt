class Solution {
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val bannedIdMatch = mutableListOf<MutableList<String>>()
        
        for (banned in banned_id) {
            val possibleUsers = mutableListOf<String>()
            
            for (user in user_id) {
                if (isMatch(user, banned)) {
                    possibleUsers.add(user)
                }
            }
            bannedIdMatch.add(possibleUsers)
        }
        
        val resultSet = mutableSetOf<Set<String>>()
        backtrack(bannedIdMatch, resultSet, 0, mutableSetOf())
        
        return resultSet.size
    }

    fun isMatch(user: String, banned: String): Boolean {
        if (user.length != banned.length) return false
        
        for (i in user.indices) {
            if (banned[i] != '*' && banned[i] != user[i]) {
                return false
            }
        }
        return true
    }
    
    fun backtrack(
        bannedIdMatch: List<MutableList<String>>, 
        resultSet: MutableSet<Set<String>>, 
        idx: Int, 
        currentSet: MutableSet<String>
    ) {
        if (idx == bannedIdMatch.size) {
            resultSet.add(currentSet.toSet())
            return
        }
        
        for (user in bannedIdMatch[idx]) {
            if (!currentSet.contains(user)) {
                currentSet.add(user)
                backtrack(bannedIdMatch, resultSet, idx + 1, currentSet)
                currentSet.remove(user)
            }
        }
    }
}
