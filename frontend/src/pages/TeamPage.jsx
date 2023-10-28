import { useEffect } from "react"
import MatchDetailCard from "../components/MatchDetailCard"
import MatchSmallCard from "../components/MatchSmallCard"
import { useState } from "react"
import { useParams } from "react-router-dom"
import "./TeamPage.scss"
import { PieChart } from 'react-minimal-pie-chart'
import { Link } from "react-router-dom"

export const TeamPage = () => {

    const [team, setTeam] = useState({ matches: [] })
    const { teamName } = useParams()

    useEffect(
        () => {
            const fetchTeam = async () => {
                const response = await fetch(`http://localhost:8080/api/v1/teams/${teamName}`)
                const data = await response.json()
                setTeam(data)
            }
            fetchTeam()
        }, [teamName]
    )

    const imageUrl = `/assets/${teamName}.png`

    return (
        <>
            <div className="TeamPage">
                <div className="team-name-section">
                    <div className="more-link1">
                        <Link to={`/`}></Link>
                    </div>
                    <div className="team-image">
                        <img className="team-image-tag" src={imageUrl} alt="" />
                    </div>
                    <div>
                        <h1 className="team-name">{team.teamName}</h1>
                    </div>
                </div>
                <div className="win-loss-section"><span className="win-loss-info">Wins: {team.totalWins} / Losses: {team.totalMatches - team.totalWins}</span>

                    <PieChart
                        data={[
                            { title: 'Losses', value: team.totalMatches - team.totalWins, color: '#a34d5d' },
                            { title: 'Wins', value: team.totalWins, color: '#4da375' }
                        ]}


                    />


                </div>
                <div className="match-detail-section">
                    <h3 className="latest-matches">Latest Matches</h3>
                    <MatchDetailCard teamName={team.teamName} match={team.matches[0]} />
                </div>

                {team.matches.slice(1).map(match => <MatchSmallCard teamName={team.teamName} key={match.id} match={match} />)}

                <div className="more-link">
                    <Link to={`/teams/${teamName}/matches/2020`}>&#8594;</Link>
                </div>

            </div>
        </>
    )
}