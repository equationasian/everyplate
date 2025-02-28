import { Link, NavLink } from "react-router";

export default function Navbar() {
    return (
        <nav className="bg-white/75 flex justify-between w-screen h-[8vh]">
            <span>logo</span>
            <div className="flex justify-center items-center gap-x-[50px]">
                <NavLink 
                    to="/meals" 
                    className={({ isActive }) => isActive ? "text-[#d9a4b3]" : "text-[#81606a] transition duration-[0.3s] ease-in-out hover:text-[#d9a4b3] hover:border-b-2 hover:border-[#d9a4b3]"}
                >
                    Recipes
                </NavLink>
                <NavLink to="/planner"
                    className={({ isActive }) => isActive ? "text-[#d9a4b3]" : "text-[#81606a] transition duration-[0.3s] ease-in-out hover:text-[#d9a4b3] hover:border-b-2 hover:border-[#d9a4b3]"}
                >
                    Planner
                </NavLink>
            </div>
            <Link to="/login">Login</Link>
        </nav>
    );
}