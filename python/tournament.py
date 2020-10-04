n = int(input())
team_win_count = dict()
total = (n * (n-1)) // 2
while total != 0:
    home_team, away_team, scores = list(map(str, input().strip().split()))
    home_team_score, away_team_score = map(int, scores.split("-"))
    if home_team_score > away_team_score:
        team_win_count[home_team] = team_win_count.get(home_team, 0) + 3
        team_win_count[away_team] = team_win_count.get(away_team, 0) + 0
    elif home_team_score == away_team_score:
        team_win_count[home_team] = team_win_count.get(home_team, 0) + 1
        team_win_count[away_team] = team_win_count.get(away_team, 0) + 1
    else:
        team_win_count[home_team] = team_win_count.get(home_team, 0) + 0
        team_win_count[away_team] = team_win_count.get(away_team, 0) + 3
    total -= 1
leader_team = max(team_win_count, key=team_win_count.get)
print(leader_team)
print(team_win_count[leader_team])