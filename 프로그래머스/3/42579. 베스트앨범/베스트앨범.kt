class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        // 1. 장르별 총 재생 횟수 
        val genreTotalPlays = mutableMapOf<String, Int>()
        
        // 2. 장르별 (고유번호, 재생수) 저장
        val genreToSongs = mutableMapOf<String, MutableList<Pair<Int, Int>>>()
        
        for(i in genres.indices) {
            val genre = genres[i]
            val play = plays[i]

            genreTotalPlays[genre] = genreTotalPlays.getOrDefault(genre, 0) + play
            genreToSongs.computeIfAbsent(genre) { mutableListOf() }.add(Pair(i, play))
        }
        
        val sortedGenres = genreTotalPlays.entries.sortedByDescending { it.value }.map { it.key }
        for(genre in sortedGenres) {
            // 4. 장르 내에서 노래를 재생수 내림차순, 같으면 고유번호 오름차순으로 정렬
            val songs = genreToSongs[genre]!!
                            .sortedWith(compareBy({ -it.second }, { it.first }))
            
            // 최대 2곡
            answer.add(songs[0].first)
            if(songs.size > 1) {
                answer.add(songs[1].first)
            }
        }
        
        return answer.toIntArray()
    }
}