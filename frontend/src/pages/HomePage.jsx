import { useEffect } from "react"
import { useState } from "react"
import "./HomePage.scss"
import TeamTile from '../components/TeamTile'
import IPL from "../assets/ipl.png"

export const HomePage = () => {

    const [teams, setTeams] = useState([])
    useEffect(
        () => {
            const fetchTeams = async () => {
                const response = await fetch(`http://localhost:8080/api/v1/teams`)
                const data = await response.json()
                setTeams(data)
            }
            fetchTeams()
        }, []
    )
    return (
        <>
            <div className="HomePage">
                <div className="header-section">
                    <img src={IPL} alt="IPL Logo" />
                </div>

                <div className="team-grid">
                    {teams.map(team => <TeamTile key={team.id} teamName={team.teamName} />)}
                </div>
            </div>
        </>
    )
}